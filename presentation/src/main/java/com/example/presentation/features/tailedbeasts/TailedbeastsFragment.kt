package com.example.presentation.features.tailedbeasts

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.example.domain.tailedbeasts.TailedBeast
import com.example.domain.tailedbeasts.toCharacter
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentTailedBeastBinding
import com.example.presentation.extensions.getError
import com.example.presentation.extensions.gone
import com.example.presentation.extensions.showError
import com.example.presentation.extensions.showErrorApi
import com.example.presentation.extensions.toJson
import com.example.presentation.extensions.visible
import com.example.presentation.features.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class TailedbeastsFragment :
    BaseFragment<FragmentTailedBeastBinding>(R.layout.fragment_tailed_beast) {


    private val viewModel: TailedbeastsViewModel by viewModels()
    private val adapter = TailedbeastsAdapter { clickOnTailedBeast(it) }
    override fun configureToolbar() = MainActivity.ToolbarConfiguration(
        showToolbar = true, toolbarTitle = getString(R.string.tailed_beasts)
    )

    override fun setUpUi() = with(binding) {
        recycler.adapter = adapter
        getVillages()
        listenerAdapter()
    }

    private fun clickOnTailedBeast(tailedBeast: TailedBeast) {
        findNavController().navigate(
            TailedbeastsFragmentDirections.navigationToCharactersDetailFragment(
                tailedBeast.toCharacter().toJson()
            )
        )
    }

    private fun getVillages() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getTailedBeastsPagingSource.collectLatest { characters ->
                    adapter.submitData(lifecycle, characters)
                }
            }
        }
    }

    private fun listenerAdapter() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                adapter.addLoadStateListener { loadState ->
                    if (loadState.source.append is LoadState.Loading || loadState.source.refresh is LoadState.Loading) {
                        binding.progress.progressBar.visible()
                    } else {
                        binding.progress.progressBar.gone()
                    }
                    val errorState = loadState.getError()
                    errorState?.showError {
                        showErrorApi(true)
                    }
                }
            }
        }
    }

}
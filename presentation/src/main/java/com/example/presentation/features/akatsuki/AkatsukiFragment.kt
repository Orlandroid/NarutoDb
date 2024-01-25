package com.example.presentation.features.akatsuki

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.example.domain.akatsuki.Akatsuki
import com.example.domain.akatsuki.toCharacter
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentAkatsukiBinding
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
class AkatsukiFragment : BaseFragment<FragmentAkatsukiBinding>(R.layout.fragment_akatsuki) {
    private val viewModel: AkatsukiViewModel by viewModels()
    private val adapter = AkatsukiAdapter { clickOnAkatsuki(it) }
    override fun configureToolbar() = MainActivity.ToolbarConfiguration(
        showToolbar = true,
        toolbarTitle = getString(R.string.akatsuki)
    )

    override fun setUpUi() = with(binding) {
        recycler.adapter = adapter
        getTeams()
        listenerAdapter()
    }

    private fun clickOnAkatsuki(akatsuki: Akatsuki) {
        findNavController().navigate(
            AkatsukiFragmentDirections.navigationToCharactersDetailFragment(
                akatsuki.toCharacter().toJson()
            )
        )
    }

    private fun getTeams() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getAkatsukiPagingSource.collectLatest { characters ->
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
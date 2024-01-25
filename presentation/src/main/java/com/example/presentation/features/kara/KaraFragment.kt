package com.example.presentation.features.kara

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.example.domain.kara.Kara
import com.example.domain.kara.toCharacter
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentKaraBinding
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
class KaraFragment :
    BaseFragment<FragmentKaraBinding>(R.layout.fragment_kara) {


    private val viewModel: KaraViewModel by viewModels()
    private val adapter = KaraAdapter { clickOnKara(it) }
    override fun configureToolbar() = MainActivity.ToolbarConfiguration(
        showToolbar = true,
        toolbarTitle = getString(R.string.kara)
    )

    override fun setUpUi() = with(binding) {
        recycler.adapter = adapter
        getVillages()
        listenerAdapter()
    }

    private fun clickOnKara(kara: Kara) {
        findNavController().navigate(
            KaraFragmentDirections.navigationToCharactersDetailFragment(
                kara.toCharacter().toJson()
            )
        )
    }

    private fun getVillages() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getKaraPagingSource.collectLatest { characters ->
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
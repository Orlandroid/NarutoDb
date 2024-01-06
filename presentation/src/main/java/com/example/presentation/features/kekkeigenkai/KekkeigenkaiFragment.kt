package com.example.presentation.features.kekkeigenkai

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import com.example.domain.kekkeigenkai.Kekkeigenkai
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentKekkeigenkaiBinding
import com.example.presentation.extensions.getError
import com.example.presentation.extensions.hideProgress
import com.example.presentation.extensions.showError
import com.example.presentation.extensions.showErrorApi
import com.example.presentation.extensions.showProgress
import com.example.presentation.features.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class KekkeigenkaiFragment :
    BaseFragment<FragmentKekkeigenkaiBinding>(R.layout.fragment_kekkeigenkai) {


    private val viewModel: KekkeigenkaiViewModel by viewModels()
    private val adapter = KekkeigenkaiAdapter { clickOnKekkeigenkai(it) }
    override fun configureToolbar() = MainActivity.ToolbarConfiguration(
        showToolbar = true,
        toolbarTitle = getString(R.string.kekkeigenkai)
    )

    override fun setUpUi() = with(binding) {
        recycler.adapter = adapter
        getVillages()
        listenerAdapter()
    }

    private fun clickOnKekkeigenkai(kekkeigenkai: Kekkeigenkai) {

    }

    private fun getVillages() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getCharactersPagingSource.collectLatest { characters ->
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
                        showProgress()
                    } else {
                        hideProgress()
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
package com.example.presentation.features.villages

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.example.domain.villages.Village
import com.example.domain.villages.VillagesWithImages
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentVillagesBinding
import com.example.presentation.extensions.getError
import com.example.presentation.extensions.gone
import com.example.presentation.extensions.hideProgress
import com.example.presentation.extensions.readRawJson
import com.example.presentation.extensions.showError
import com.example.presentation.extensions.showErrorApi
import com.example.presentation.extensions.showLog
import com.example.presentation.extensions.showProgress
import com.example.presentation.extensions.visible
import com.example.presentation.features.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class VillagesFragment : BaseFragment<FragmentVillagesBinding>(R.layout.fragment_villages) {


    private val viewModel: VillagesViewModel by viewModels()
    private val adapter = VillagesAdapter { clickOnVillage(it) }
    override fun configureToolbar() = MainActivity.ToolbarConfiguration(
        showToolbar = true,
        toolbarTitle = getString(R.string.villages)
    )

    override fun setUpUi() = with(binding) {
        recycler.adapter = adapter
        getVillages()
        listenerAdapter()
    }

    private fun getVillagesImages() {
        readRawJson<List<VillagesWithImages>>(R.raw.villages).forEach {
            showLog(it.name)
        }
    }

    private fun clickOnVillage(clickOnVillage: Village) {
        findNavController().navigate(VillagesFragmentDirections.actionVillagesFragmentToVillageDetailFragment())
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
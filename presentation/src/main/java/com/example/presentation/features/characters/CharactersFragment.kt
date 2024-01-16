package com.example.presentation.features.characters

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.example.domain.characters.Character
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentCharactersBinding
import com.example.presentation.extensions.fromJson
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
class CharactersFragment : BaseFragment<FragmentCharactersBinding>(R.layout.fragment_characters) {

    override fun configureToolbar() = MainActivity.ToolbarConfiguration(
        showToolbar = true,
        toolbarTitle = getString(R.string.characters)
    )

    private val viewModel: CharactersViewModel by viewModels()
    private val adapter = CharacterAdapter {
        findNavController().navigate(
            CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailFragment(
                it.toJson()
            )
        )
    }

    data class MyCharacters(
        val characters: List<Character>
    )

    private val args: CharactersFragmentArgs by navArgs()
    override fun setUpUi() = with(binding) {
        recycler.adapter = adapter
        if (args.myCharacters.fromJson<MyCharacters>().characters.isEmpty()) {
            listenData()
        } else {
            setDataFromArgs()
        }
    }

    private fun listenData() {
        getCharacters()
        listenerAdapter()
    }

    private fun setDataFromArgs() {
        val characters = args.myCharacters.fromJson<MyCharacters>().characters
        lifecycleScope.launch {
            adapter.submitData(PagingData.from(characters))
        }
    }

    private fun getCharacters() {
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
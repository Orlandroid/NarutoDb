package com.example.presentation.features.characters

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.data.characters.CharactersApi
import com.example.data.characters.CharactersPagingSource
import com.example.data.di.CoroutineDispatchers
import com.example.data.utils.getPagingConfig
import com.example.domain.common.Character
import com.example.presentation.base.BaseViewModel
import com.example.presentation.helpers.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersApi: CharactersApi,
    coroutineDispatchers: CoroutineDispatchers,
    networkHelper: NetworkHelper
) : BaseViewModel(coroutineDispatchers, networkHelper) {


    private lateinit var charactersPagingSource: CharactersPagingSource

    val getCharactersPagingSource: Flow<PagingData<Character>> =
        Pager(
            config = getPagingConfig(),
            pagingSourceFactory = {
                charactersPagingSource =
                    CharactersPagingSource(
                        charactersApi = charactersApi
                    )
                charactersPagingSource
            }
        ).flow.cachedIn(viewModelScope)

    fun refreshCharactersPagingSource() = charactersPagingSource.invalidate()


}

package com.example.presentation.ui.clans

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.data.clans.ClansApi
import com.example.data.clans.ClansPagingSource
import com.example.data.di.CoroutineDispatchers
import com.example.data.utils.getPagingConfig
import com.example.domain.clans.Clan
import com.example.presentation.base.BaseViewModel
import com.example.presentation.helpers.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ClansViewModel @Inject constructor(
    private val service: ClansApi,
    coroutineDispatchers: CoroutineDispatchers,
    networkHelper: NetworkHelper
) : BaseViewModel(coroutineDispatchers, networkHelper) {


    private lateinit var charactersPagingSource: ClansPagingSource

    val getCharactersPagingSource: Flow<PagingData<Clan>> =
        Pager(
            config = getPagingConfig(),
            pagingSourceFactory = {
                charactersPagingSource = ClansPagingSource(service = service)
                charactersPagingSource
            }
        ).flow.cachedIn(viewModelScope)

    fun refreshCharactersPagingSource() = charactersPagingSource.invalidate()


}

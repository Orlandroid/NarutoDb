package com.example.presentation.features.tailedbeasts

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.data.di.CoroutineDispatchers
import com.example.data.tailedbeasts.TailedBeastsApi
import com.example.data.tailedbeasts.TailedBeastsPagingSource
import com.example.data.utils.getPagingConfig
import com.example.domain.tailedbeasts.TailedBeast
import com.example.presentation.base.BaseViewModel
import com.example.presentation.helpers.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class TailedbeastsViewModel @Inject constructor(
    private val service: TailedBeastsApi,
    coroutineDispatchers: CoroutineDispatchers,
    networkHelper: NetworkHelper
) : BaseViewModel(coroutineDispatchers, networkHelper) {


    private lateinit var tailedBeastsPagingSource: TailedBeastsPagingSource

    val getTailedBeastsPagingSource: Flow<PagingData<TailedBeast>> =
        Pager(
            config = getPagingConfig(),
            pagingSourceFactory = {
                tailedBeastsPagingSource = TailedBeastsPagingSource(service = service)
                tailedBeastsPagingSource
            }
        ).flow.cachedIn(viewModelScope)

    fun refreshTailedBeastsSource() = tailedBeastsPagingSource.invalidate()


}

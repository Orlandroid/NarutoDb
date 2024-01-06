package com.example.presentation.features.kekkeigenkai

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.data.di.CoroutineDispatchers
import com.example.data.kekkeigenkai.KekkeigenkaiApi
import com.example.data.kekkeigenkai.KekkeigenkaiPagingSource
import com.example.data.utils.getPagingConfig
import com.example.domain.kekkeigenkai.Kekkeigenkai
import com.example.presentation.base.BaseViewModel
import com.example.presentation.helpers.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class KekkeigenkaiViewModel @Inject constructor(
    private val service: KekkeigenkaiApi,
    coroutineDispatchers: CoroutineDispatchers,
    networkHelper: NetworkHelper
) : BaseViewModel(coroutineDispatchers, networkHelper) {


    private lateinit var kekkeigenkaiPagingSource: KekkeigenkaiPagingSource

    val getCharactersPagingSource: Flow<PagingData<Kekkeigenkai>> =
        Pager(
            config = getPagingConfig(),
            pagingSourceFactory = {
                kekkeigenkaiPagingSource = KekkeigenkaiPagingSource(service = service)
                kekkeigenkaiPagingSource
            }
        ).flow.cachedIn(viewModelScope)

    fun refreshKekkeigenkaiPagingSourcePagingSource() = kekkeigenkaiPagingSource.invalidate()


}

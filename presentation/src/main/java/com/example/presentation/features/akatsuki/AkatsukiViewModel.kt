package com.example.presentation.features.akatsuki

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import com.example.data.akatsuki.AkatsukiApi
import com.example.data.akatsuki.AkatsukiPagingSource
import com.example.data.di.CoroutineDispatchers
import com.example.data.utils.getPagingConfig
import com.example.presentation.base.BaseViewModel
import com.example.presentation.helpers.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AkatsukiViewModel @Inject constructor(
    private val service: AkatsukiApi,
    coroutineDispatchers: CoroutineDispatchers,
    networkHelper: NetworkHelper
) : BaseViewModel(coroutineDispatchers, networkHelper) {


    private lateinit var akatsukiPagingSource: AkatsukiPagingSource

    val getAkatsukiPagingSource =
        Pager(
            config = getPagingConfig(),
            pagingSourceFactory = {
                akatsukiPagingSource = AkatsukiPagingSource(service = service)
                akatsukiPagingSource
            }
        ).flow.cachedIn(viewModelScope)

    fun refreshAkatsukiPagingSource() = akatsukiPagingSource.invalidate()


}

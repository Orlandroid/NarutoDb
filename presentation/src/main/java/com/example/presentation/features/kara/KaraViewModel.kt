package com.example.presentation.features.kara

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.data.di.CoroutineDispatchers
import com.example.data.kara.KaraApi
import com.example.data.kara.KaraPagingSource
import com.example.data.utils.getPagingConfig
import com.example.domain.kara.Kara
import com.example.presentation.base.BaseViewModel
import com.example.presentation.helpers.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class KaraViewModel @Inject constructor(
    private val service: KaraApi,
    coroutineDispatchers: CoroutineDispatchers,
    networkHelper: NetworkHelper
) : BaseViewModel(coroutineDispatchers, networkHelper) {


    private lateinit var karaPagingSource: KaraPagingSource

    val getKaraPagingSource: Flow<PagingData<Kara>> =
        Pager(
            config = getPagingConfig(),
            pagingSourceFactory = {
                karaPagingSource = KaraPagingSource(service = service)
                karaPagingSource
            }
        ).flow.cachedIn(viewModelScope)

    fun refreshKaraPagingSource() = karaPagingSource.invalidate()


}

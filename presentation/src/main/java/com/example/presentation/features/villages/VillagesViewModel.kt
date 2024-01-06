package com.example.presentation.features.villages

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.data.di.CoroutineDispatchers
import com.example.data.utils.getPagingConfig
import com.example.data.villages.VillagesApi
import com.example.data.villages.VillagesPagingSource
import com.example.domain.villages.Village
import com.example.presentation.base.BaseViewModel
import com.example.presentation.helpers.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class VillagesViewModel @Inject constructor(
    private val service: VillagesApi,
    coroutineDispatchers: CoroutineDispatchers,
    networkHelper: NetworkHelper
) : BaseViewModel(coroutineDispatchers, networkHelper) {


    private lateinit var villagesPagingSource: VillagesPagingSource

    val getCharactersPagingSource: Flow<PagingData<Village>> =
        Pager(
            config = getPagingConfig(),
            pagingSourceFactory = {
                villagesPagingSource = VillagesPagingSource(service = service)
                villagesPagingSource
            }
        ).flow.cachedIn(viewModelScope)

    fun refreshVillagesPagingSource() = villagesPagingSource.invalidate()


}

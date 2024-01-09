package com.example.presentation.features.teams

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import com.example.data.di.CoroutineDispatchers
import com.example.data.teams.TeamsApi
import com.example.data.teams.TeamsPagingSource
import com.example.data.utils.getPagingConfig
import com.example.presentation.base.BaseViewModel
import com.example.presentation.helpers.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamsViewModel @Inject constructor(
    private val service: TeamsApi,
    coroutineDispatchers: CoroutineDispatchers,
    networkHelper: NetworkHelper
) : BaseViewModel(coroutineDispatchers, networkHelper) {


    private lateinit var teamsPagingSource: TeamsPagingSource

    val getTeamsPagingSource =
        Pager(
            config = getPagingConfig(),
            pagingSourceFactory = {
                teamsPagingSource = TeamsPagingSource(service = service)
                teamsPagingSource
            }
        ).flow.cachedIn(viewModelScope)

    fun refreshTeamsPagingSource() = teamsPagingSource.invalidate()


}

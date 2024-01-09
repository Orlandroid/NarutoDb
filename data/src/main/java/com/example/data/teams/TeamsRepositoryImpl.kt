package com.example.data.teams

import com.example.domain.teams.TeamsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamsRepositoryImpl @Inject constructor(private val teamsApi: TeamsApi) :
    TeamsRepository {
    override suspend fun getAllTeams(page: String) = teamsApi.getAllTeams(page)

}
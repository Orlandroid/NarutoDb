package com.example.domain.teams


interface TeamsRepository {
    suspend fun getAllTeams(page: String): TeamsResponse
}
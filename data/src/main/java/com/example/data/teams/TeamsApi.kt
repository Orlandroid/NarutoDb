package com.example.data.teams


import com.example.domain.teams.TeamsResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface TeamsApi {

    @GET("team")
    suspend fun getAllTeams(
        @Query("page") page: String,
        @Query("limit") limit: String = "10"
    ): TeamsResponse


}
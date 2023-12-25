package com.example.data.clans


import com.example.domain.clans.ClansResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ClansApi {

    @GET("clan")
    suspend fun getAllClans(
        @Query("page") page: String,
        @Query("limit") limit: String = "10"
    ): ClansResponse

}
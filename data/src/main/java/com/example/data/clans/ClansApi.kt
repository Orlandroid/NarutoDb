package com.example.data.clans


import com.example.domain.clans.ClansResponse
import com.example.domain.clans.ClansResponseV2
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface ClansApi {

    @GET
    suspend fun getAllClans(
        @Url url: String = "https://narutodb.xyz/api/clan",
        @Query("page") page: String,
        @Query("limit") limit: String = "10"
    ): ClansResponse

    @GET("clans")
    suspend fun getAllClans(): List<ClansResponseV2>

}
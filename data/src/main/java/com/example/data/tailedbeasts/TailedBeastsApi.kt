package com.example.data.tailedbeasts


import com.example.domain.tailedbeasts.TailedBeastsResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface TailedBeastsApi {

    @GET("tailed-beast")
    suspend fun getAllTailedBeasts(
        @Query("page") page: String,
        @Query("limit") limit: String = "10"
    ): TailedBeastsResponse


}
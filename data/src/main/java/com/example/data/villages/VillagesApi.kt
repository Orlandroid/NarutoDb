package com.example.data.villages


import com.example.domain.villages.VillagesResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface VillagesApi {

    @GET("village")
    suspend fun getAllVillages(
        @Query("page") page: String,
        @Query("limit") limit: String = "10"
    ): VillagesResponse


}
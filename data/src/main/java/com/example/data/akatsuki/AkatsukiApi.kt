package com.example.data.akatsuki


import com.example.domain.akatsuki.AkatsukiResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface AkatsukiApi {

    @GET("akatsuki")
    suspend fun getAllAkatsuki(
        @Query("page") page: String,
        @Query("limit") limit: String = "10"
    ): AkatsukiResponse


}
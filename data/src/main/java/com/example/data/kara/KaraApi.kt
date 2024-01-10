package com.example.data.kara


import com.example.domain.kara.KaraResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface KaraApi {

    @GET("kara")
    suspend fun getAllAkara(
        @Query("page") page: String,
        @Query("limit") limit: String = "10"
    ): KaraResponse


}
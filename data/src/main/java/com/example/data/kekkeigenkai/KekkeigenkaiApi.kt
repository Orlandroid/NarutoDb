package com.example.data.kekkeigenkai


import com.example.domain.kekkeigenkai.KekkeigenkaiResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface KekkeigenkaiApi {

    @GET("kekkei-genkai")
    suspend fun getAllKekkeigenkai(
        @Query("page") page: String,
        @Query("limit") limit: String = "10"
    ): KekkeigenkaiResponse


}
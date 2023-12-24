package com.example.data.characters


import com.example.domain.characters.Character
import com.example.domain.characters.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface CharactersApi {

    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") page: String,
        @Query("limit") limit: String = "10"
    ): CharactersResponse

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Character
}
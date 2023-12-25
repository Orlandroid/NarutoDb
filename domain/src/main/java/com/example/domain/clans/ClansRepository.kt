package com.example.domain.clans


interface ClansRepository {
    suspend fun getAllCharacters(page:String): ClansResponse
}
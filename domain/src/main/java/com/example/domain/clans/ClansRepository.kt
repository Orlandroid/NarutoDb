package com.example.domain.clans


interface ClansRepository {
    suspend fun getAllCharacters(page:String): ClansResponse

    suspend fun getAllClans(page:String): List<ClansResponseV2>
}
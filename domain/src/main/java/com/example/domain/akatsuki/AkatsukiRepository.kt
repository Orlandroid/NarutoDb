package com.example.domain.akatsuki


interface AkatsukiRepository {
    suspend fun getAllAkatsuki(page: String): AkatsukiResponse
}
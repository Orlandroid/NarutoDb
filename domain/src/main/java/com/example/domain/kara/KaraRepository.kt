package com.example.domain.kara


interface KaraRepository {
    suspend fun getAllKara(page: String): KaraResponse
}
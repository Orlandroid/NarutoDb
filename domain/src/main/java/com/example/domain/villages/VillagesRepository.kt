package com.example.domain.villages


interface VillagesRepository {
    suspend fun getAllVillages(page: String): VillagesResponse
}
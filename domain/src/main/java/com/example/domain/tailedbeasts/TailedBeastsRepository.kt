package com.example.domain.tailedbeasts


interface TailedBeastsRepository {
    suspend fun getAllTailedBeasts(page: String): TailedBeastsResponse
}
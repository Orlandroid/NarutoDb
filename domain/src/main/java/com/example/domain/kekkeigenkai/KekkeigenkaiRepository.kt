package com.example.domain.kekkeigenkai


interface KekkeigenkaiRepository {
    suspend fun getAllGenkais(page: String): KekkeigenkaiResponse
}
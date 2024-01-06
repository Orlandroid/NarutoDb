package com.example.domain.kekkeigenkai

import kotlinx.serialization.Serializable


@Serializable
data class KekkeigenkaiResponse(
    val kekkeigenkai: List<Kekkeigenkai>
)

@Serializable
data class Kekkeigenkai(
    val id: Int,
    val name: String
)
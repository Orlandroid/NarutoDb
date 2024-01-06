package com.example.domain.villages

import kotlinx.serialization.Serializable

@Serializable
data class VillagesWithImages(
    val name: String,
    val image: String,
    val description: String,
)
package com.example.domain.common

import kotlinx.serialization.Serializable

@Serializable
data class VoiceActors(
    @Serializable(UnwrappingJsonStringToListSerializerV2::class)
    val english: List<String>? = null,
    @Serializable(UnwrappingJsonStringToListSerializerV2::class)
    val japanese: List<String>? = null
)
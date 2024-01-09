package com.example.domain.common

import kotlinx.serialization.Serializable


@Serializable
data class Debut(
    val anime: String? = null,
    val appearsIn: String,
    val game: String? = null,
    val manga: String? = null,
    val movie: String? = null,
    val novel: String? = null,
    val ova: String? = null
)
package com.example.domain.common

import kotlinx.serialization.Serializable


@Serializable
data class Debut(
    val anime: String? = null,
    val appearsIn: String? = null,
    val game: String? = null,
    val manga: String? = null,
    val movie: String? = null,
    val novel: String? = null,
    val ova: String? = null
) {
    fun getDebut(): String? {
        anime?.let {
            return it
        }
        appearsIn?.let {
            return it
        }
        game?.let {
            return it
        }
        manga?.let {
            return it
        }
        movie?.let {
            return it
        }
        novel?.let {
            return it
        }
        ova?.let {
            return it
        }
        return null
    }
}
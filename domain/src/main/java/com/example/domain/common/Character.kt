package com.example.domain.common

import com.example.domain.characters.Rank
import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val debut: Debut? = null,
    val family: Family? = null,
    val id: Int,
    val images: List<String> = emptyList(),
    val jutsu: List<String>? = null,
    val name: String,
    val natureType: List<String>? = null,
    val personal: Personal? = null,
    //@Serializable(UnwrappingJsonReturnEmptyObject::class)
    val rank: Rank? = null,
    val tools: List<String>? = null,
)
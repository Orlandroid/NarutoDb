package com.example.domain.clans

import com.example.domain.characters.Character
import kotlinx.serialization.Serializable


@Serializable
data class ClansResponse(
    val clans: List<Clan>
)

@Serializable
data class Clan(
    val id: Int,
    val name: String,
    val characters: List<Character>
)
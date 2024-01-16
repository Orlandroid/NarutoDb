package com.example.domain.villages

import com.example.domain.characters.Character
import kotlinx.serialization.Serializable

@Serializable
data class VillagesResponse(
    val villages: List<Village>
)

@Serializable
data class Village(
    val id: Int, val name: String, val characters: List<Character>
)
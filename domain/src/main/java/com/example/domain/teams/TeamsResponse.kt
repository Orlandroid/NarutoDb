package com.example.domain.teams

import com.example.domain.common.Character
import kotlinx.serialization.Serializable


@Serializable
data class TeamsResponse(
    val teams: List<Team>
)


@Serializable
data class Team(
    val id: Int,
    val name: String,
    val characters: List<Character>
)
package com.example.domain.clans

import kotlinx.serialization.Serializable


@Serializable
data class ClansResponse(
    val clans: List<Clan>
)

@Serializable
data class Clan(
    val id: Int,
    val name: String
)
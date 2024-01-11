package com.example.domain.akatsuki


import com.example.domain.common.Debut
import com.example.domain.common.Family
import com.example.domain.common.Personal
import com.example.domain.common.VoiceActors
import kotlinx.serialization.Serializable

@Serializable
data class AkatsukiResponse(
    val akatsuki: List<Akatsuki>
)

@Serializable
data class Akatsuki(
    val debut: Debut? = null,
    val family: Family? = null,
    val id: Int,
    val images: List<String>,
    val jutsu: List<String>? = null,
    val name: String,
    val natureType: List<String>? = null,
    val personal: Personal? = null,
    val uniqueTraits: List<String>? = null,
    val voiceActors: VoiceActors? = null
)
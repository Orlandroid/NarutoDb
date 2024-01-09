package com.example.domain.characters

import com.example.domain.common.Debut
import com.example.domain.common.Family
import com.example.domain.common.VoiceActors
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharactersResponse(
    val characters: List<Character>,
    val currentPage: Int,
    val pageSize: Int,
    val totalCharacters: Int
)

@Serializable
data class Character(
    val debut: Debut? = null,
    val family: Family? = null,
    val id: Int,
    val images: List<String> = emptyList(),
    val jutsu: List<String>? = null,
    val name: String,
    val natureType: List<String>? = null,
    //val personal: Personal? = null,
    val rank: Rank? = null,
    val tools: List<String>? = null,
    val voiceActors: VoiceActors? = null
)

@Serializable
data class Rank(
    val ninjaRank: NinjaRank? = null, val ninjaRegistration: String? = null
)




@Serializable
data class Age(
    @SerialName("Academy Graduate") val academyGraduate: String? = null,
    @SerialName("Chunin Promotion") val chuninPromotion: String? = null,
    @SerialName("Part I") val partI: String? = null,
    @SerialName("Part II") val partII: String? = null
)

@Serializable
data class Height(
    @SerialName("Part I") val partI: String? = null,
    @SerialName("Part II") val partII: String? = null
)

@Serializable
data class Weight(
    @SerialName("Part I") val partI: String? = null,
    @SerialName("Part II") val partII: String? = null
)

@Serializable
data class NinjaRank(
    @SerialName("Gaiden") val gaiden: String? = null,
    @SerialName("Part I") val partI: String? = null,
    @SerialName("Part II") val partII: String? = null
)
package com.example.domain.characters

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
data class Debut(
    val anime: String? = null,
    val appearsIn: String,
    val game: String? = null,
    val manga: String? = null,
    val movie: String? = null,
    val novel: String? = null,
    val ova: String? = null
)

@Serializable
data class Family(
    val brother: String? = null,
    val daughter: String? = null,
    val father: String? = null,
    val granddaughter: String? = null,
    val grandfather: String? = null,
    val husband: String? = null,
    val son: String? = null,
    val spouse: String? = null
)

@Serializable
data class Personal(
    @Serializable(UnwrappingJsonStringToListSerializerV2::class)
    val affiliation: List<String>? = null,
    val age: Age? = null,
    val birthdate: String? = null,
    val bloodType: String? = null,
    val clan: String? = null,
    val classification: String? = null,
    val height: Height? = null,
    @Serializable(UnwrappingJsonOccupationListSerializer::class)
    val occupation: List<String>? = null,
    val partner: String? = null,
    val sex: String? = null,
    val status: String? = null,
    @Serializable(UnwrappingJsonStringToListSerializerV2::class)
    val team: List<String>? = null,
    val titles: List<String>? = null,
    val weight: Weight? = null
)

@Serializable
data class Rank(
    val ninjaRank: NinjaRank? = null, val ninjaRegistration: String? = null
)

@Serializable
data class VoiceActors(
    @Serializable(UnwrappingJsonStringToListSerializerV2::class)
    val english: List<String>? = null,
    @Serializable(UnwrappingJsonStringToListSerializerV2::class)
    val japanese: List<String>? = null
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
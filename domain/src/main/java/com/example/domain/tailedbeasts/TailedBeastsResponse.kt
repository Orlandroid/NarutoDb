package com.example.domain.tailedbeasts

import com.example.domain.characters.UnwrappingJsonStringToListSerializerV2
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class TailedBeastsResponse(
    val tailedBeasts: List<TailedBeast>
)


@Serializable
data class TailedBeast(
    val debut: Debut? = null,
    val family: Family,
    val id: Int,
    val images: List<String>,
    val jutsu: List<String>,
    val name: String,
    val natureType: List<String> = emptyList(),
    val personal: Personal,
    val uniqueTraits: List<String> = emptyList()
)

@Serializable
data class Debut(
    val anime: String,
    val appearsIn: String,
    val game: String,
    val manga: String,
    val movie: String,
    val novel: String,
    val ova: String? = null
)

@Serializable
data class Family(
    @SerialName("depowered form")
    val depoweredform: String? = null,
    @SerialName("incarnation with the god tree")
    val incarnationWithTheGodtree: String? = null
)

@Serializable
data class Personal(
    @Serializable(UnwrappingJsonStringToListSerializerV2::class)
    val classification: List<String> = emptyList(),
    @SerialName("jinchūriki")
    val jinchcriki: List<String>,
    val kekkeiGenkai: String? = null,
    val status: String? = null,
    val titles: List<String> = emptyList()
)
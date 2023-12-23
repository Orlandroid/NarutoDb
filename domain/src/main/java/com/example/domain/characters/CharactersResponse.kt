package com.example.domain.characters

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonTransformingSerializer
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.serializer

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
    val images: List<String>,
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
    @Serializable(UnwrappingJsonEnglishListSerializerV2::class)
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
    @Serializable(UnwrappingJsonEnglishListSerializerV2::class)
    val team: List<String>? = null,
    val titles: List<String>? = null,
    val weight: Weight? = null
)

object PersonalSerializer : KSerializer<Personal> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("personal")

    override fun serialize(encoder: Encoder, value: Personal) {}

    override fun deserialize(decoder: Decoder): Personal {
        val input = decoder as JsonDecoder
        val jsonObj = input.decodeJsonElement().jsonObject
        val affiliation = jsonObj["affiliation"]
        val age = jsonObj["age"]
        val birthdate = jsonObj["birthdate"]
        val bloodType = jsonObj["bloodType"]
        val clan = jsonObj["clan"]
        val classification = jsonObj["classification"]
        val height = jsonObj["height"]
        val occupationList = arrayListOf<String>()
        val occupation = jsonObj["occupation"]
        if (occupation !is JsonArray) {
            occupationList.add(occupation.toString())
        }
        val partner = jsonObj["partner"]
        val sex = jsonObj["sex"]
        val status = jsonObj["status"]
        val team = jsonObj["team"]
        val titles = jsonObj["titles"]
        val weight = jsonObj["weight"]
        return Personal(
            affiliation = null,
            age = null,
            birthdate = birthdate.toString(),
            bloodType = null,
            clan = null,
            classification = null,
            height = null,
            occupation = occupationList,
            partner = null,
            sex = null,
            status = null,
            team = null,
            titles = null,
            weight = null
        )
    }
}


@Serializable
data class Rank(
    val ninjaRank: NinjaRank? = null, val ninjaRegistration: String? = null
)

@Serializable
data class VoiceActors(
    @Serializable(UnwrappingJsonEnglishListSerializerV2::class)
    val english: List<String>? = null,
    @Serializable(UnwrappingJsonEnglishListSerializerV2::class)
    val japanese: List<String>? = null
)

object SomeObjSerializer : KSerializer<VoiceActors> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("voiceActors")

    override fun serialize(encoder: Encoder, value: VoiceActors) {}

    override fun deserialize(decoder: Decoder): VoiceActors {
        val input = decoder as JsonDecoder
        val jsonObj = input.decodeJsonElement().jsonObject
        val myEnglishList = arrayListOf<String>()
        val english = jsonObj["english"]
        val japanese = jsonObj["japanese"]
        if (english !is JsonArray) {
            myEnglishList.add(english.toString())
        }
        return VoiceActors(myEnglishList, null)
    }
}

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
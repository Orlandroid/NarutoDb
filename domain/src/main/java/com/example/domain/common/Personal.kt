package com.example.domain.common

import com.example.domain.characters.Age
import com.example.domain.characters.Height
import com.example.domain.characters.Weight
import kotlinx.serialization.Serializable

@Serializable
data class Personal(
    @Serializable(UnwrappingJsonStringToListSerializerV2::class)
    val affiliation: List<String>? = null,
    val age: Age? = null,
    val birthdate: String? = null,
    val bloodType: String? = null,
    @Serializable(UnwrappingJsonStringToListSerializerV2::class)
    val clan: List<String>? = null,
    @Serializable(UnwrappingJsonStringToListSerializerV2::class)
    val classification: List<String>? = null,
    val height: Height? = null,
    @Serializable(UnwrappingJsonOccupationListSerializer::class)
    val occupation: List<String>? = null,
    @Serializable(UnwrappingJsonOccupationListSerializer::class)
    val partner: List<String>? = null,
    val sex: String? = null,
    val status: String? = null,
    @Serializable(UnwrappingJsonStringToListSerializerV2::class)
    val team: List<String>? = null,
    val titles: List<String>? = null,
    val weight: Weight? = null
)
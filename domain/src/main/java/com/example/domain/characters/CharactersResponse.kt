package com.example.domain.characters

import com.example.domain.common.Character
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
data class Rank(
    val ninjaRank: NinjaRank? = null,
    val ninjaRegistration: String? = null,
)

@Serializable
data class Age(
    @SerialName("Academy Graduate") val academyGraduate: String? = null,
    @SerialName("Chunin Promotion") val chuninPromotion: String? = null,
    @SerialName("Part I") val partI: String? = null,
    @SerialName("Part II") val partII: String? = null
) {
    fun getAge(): String? {
        academyGraduate?.let {
            return it
        }
        chuninPromotion?.let {
            return it
        }
        partI?.let {
            return it
        }
        partII?.let {
            return it
        }
        return null
    }
}

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
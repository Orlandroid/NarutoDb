package com.example.domain.kara

import com.example.domain.common.Debut
import com.example.domain.common.Family
import com.example.domain.common.Personal
import kotlinx.serialization.Serializable

@Serializable
data class KaraResponse(
    val kara: List<Kara>
)

@Serializable
data class Kara(
    val debut: Debut? = null,
    val family: Family? = null,
    val id: Int,
    val images: List<String>,
    val name: String,
    val personal: Personal,
    val tools: List<String>? = null
)


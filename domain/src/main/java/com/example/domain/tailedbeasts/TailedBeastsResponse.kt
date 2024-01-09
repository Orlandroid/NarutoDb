package com.example.domain.tailedbeasts

import com.example.domain.common.Debut
import com.example.domain.common.Family
import com.example.domain.common.Personal
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

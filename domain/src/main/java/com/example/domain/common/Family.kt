package com.example.domain.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Family(
    val creator: String? = null,
    @SerialName("depowered form")
    val depoweredform: String? = null,
    @SerialName("incarnation with the god tree")
    val incarnationWithTheGodtree: String? = null,
    val brother: String? = null,
    val daughter: String? = null,
    val father: String? = null,
    val granddaughter: String? = null,
    val grandfather: String? = null,
    val husband: String? = null,
    val son: String? = null,
    val spouse: String? = null
)
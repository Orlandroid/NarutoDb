package com.example.domain.common

import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.JsonTransformingSerializer
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.serializer


object UnwrappingJsonStringToListSerializerV2 :
    JsonTransformingSerializer<List<String>>(serializer()) {
    override fun transformDeserialize(element: JsonElement): JsonElement {
        if (element is JsonArray) return element
        return JsonArray(listOf(element))
    }
}

object UnwrappingJsonOccupationListSerializer :
    JsonTransformingSerializer<List<String>>(ListSerializer(String.serializer())) {
    override fun transformDeserialize(element: JsonElement) =
        when (element) {
            is JsonArray -> element
            is JsonObject -> JsonArray(
                listOf(
                    element.getValue("occupation")
                )
            )

            is JsonPrimitive -> {
                JsonArray(
                    listOf(
                        element
                    )
                )
            }

            else -> throw IllegalArgumentException(
                "Invalid JSON format for occupation",
            )
        }
}




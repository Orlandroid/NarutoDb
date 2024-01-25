package com.example.domain.common

import com.example.domain.characters.Rank
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.JsonTransformingSerializer
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.serializer


object UnwrappingJsonStringToListSerializerV2 :
    JsonTransformingSerializer<List<String>>(serializer()) {
    override fun transformDeserialize(element: JsonElement): JsonElement =
        if (element !is JsonArray) JsonArray(listOf(element)) else element

}

object UnwrappingJsonStringToListSerializerV3 :
    JsonTransformingSerializer<String>(serializer()) {
    override fun transformDeserialize(element: JsonElement): JsonElement =
        if (element is JsonArray) element.first()
        else element

}

//* return an empty object when we get response like the next example
// Example
// *  "rank": [  "The Springtime of Youth wiki has an article about this topic:", "Homura Mitokado"]

object UnwrappingJsonReturnEmptyObject :
    JsonTransformingSerializer<Rank>(serializer()) {
    override fun transformDeserialize(element: JsonElement): JsonElement {
        if (element is JsonObject) return element
        return buildJsonObject {

        }
    }
}

object UnwrappingJsonReturnEmptyObjectPersonal :
    JsonTransformingSerializer<Personal>(serializer()) {
    override fun transformDeserialize(element: JsonElement): JsonElement {
        if (element is JsonObject) return element
        return buildJsonObject {

        }
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




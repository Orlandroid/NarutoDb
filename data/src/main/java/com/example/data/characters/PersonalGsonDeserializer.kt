package com.example.data.characters

import com.example.domain.characters.Age
import com.example.domain.characters.Height
import com.example.domain.characters.Personal
import com.example.domain.characters.Weight
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type


class PersonalGsonDeserializer : JsonDeserializer<Personal> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Personal {
        val jsonObject = json!!.asJsonObject

        val affiliation = jsonObject["affiliation"].asString
        val age = jsonObject["age"].asJsonObject
        val myAge = Age(
            academyGraduate = age.get("Academy Graduate").asString,
            chuninPromotion = age.get("Chunin Promotion").asString,
            partI = age.get("Part I").asString,
            partII = age.get("Part II").asString
        )
        val height = jsonObject["height"].asJsonObject
        val myHeight = Height(
            partI = height["Part I"].asString,
            partII = height["Part II"].asString
        )
        val weight = jsonObject["weight"].asJsonObject
        val myWeight = Weight(
            partI = weight["Part I"].asString,
            partII = weight["Part II"].asString
        )
        val birthdate = jsonObject["birthdate"].asString
        val bloodType = jsonObject["bloodType"].asString
        val clan = jsonObject["clan"].asString
        val classification = jsonObject["classification"].asString
        val occupation = jsonObject["occupation"]
        val partner = jsonObject["partner"].asString
        val sex = jsonObject["sex"].asString
        val status = jsonObject["status"].asString
        val team = jsonObject["team"].asString
        val titles = jsonObject["titles"].asJsonArray
        val titlesList = ArrayList<String>()
        titles.forEach {
            titlesList.add(it.asString)
        }
        val myOccupationList = ArrayList<String>()
        if (occupation.isJsonArray) {
            occupation.asJsonArray.forEach {
                myOccupationList.add(it.asString)
            }
        } else {
            myOccupationList.add(occupation.asString)
        }
        return Personal(
            affiliation = null,
            age = myAge,
            birthdate = birthdate,
            bloodType = bloodType,
            clan = clan,
            classification = classification,
            height = myHeight,
            occupation = null,
            partner = partner,
            sex = sex,
            status = status,
            team = null,
            titles = titlesList,
            weight = myWeight
        )
    }

}
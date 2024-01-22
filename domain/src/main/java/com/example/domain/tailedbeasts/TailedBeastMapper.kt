package com.example.domain.tailedbeasts

import com.example.domain.characters.Character

fun TailedBeast.toCharacter(): Character {
    return Character(
        debut = debut,
        family = family,
        id = id,
        images = images,
        jutsu = jutsu,
        name = name,
        natureType = natureType,
        personal = personal
    )
}
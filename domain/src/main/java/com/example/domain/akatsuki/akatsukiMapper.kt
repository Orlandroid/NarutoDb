package com.example.domain.akatsuki

import com.example.domain.common.Character

fun Akatsuki.toCharacter() =  Character(
    id = id,
    debut = debut,
    family = family,
    name = name,
    images = images,
    personal = personal,
)
package com.example.domain.kara

import com.example.domain.common.Character

fun Kara.toCharacter() = Character(
    id = id,
    debut = debut,
    family = family,
    name = name,
    images = images,
    personal = personal,
    tools = tools,
)
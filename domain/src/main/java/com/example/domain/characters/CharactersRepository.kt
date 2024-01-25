package com.example.domain.characters

import com.example.domain.common.Character


interface CharactersRepository {
    suspend fun getAllCharacters(page:String): CharactersResponse
    suspend fun getCharactersById(characterId:Int): Character
}
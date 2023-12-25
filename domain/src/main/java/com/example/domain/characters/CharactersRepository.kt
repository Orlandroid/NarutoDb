package com.example.domain.characters


interface CharactersRepository {
    suspend fun getAllCharacters(page:String): CharactersResponse
    suspend fun getCharactersById(characterId:Int): Character
}
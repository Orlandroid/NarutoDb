package com.example.data.characters

import com.example.domain.characters.CharactersRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharactersRepositoryImpl @Inject constructor(private val charactersApi: CharactersApi) :
    CharactersRepository {

    override suspend fun getAllCharacters(page: String) =
        charactersApi.getAllCharacters(page = page)

    override suspend fun getCharactersById(characterId:Int) = charactersApi.getCharacterById(characterId)


}
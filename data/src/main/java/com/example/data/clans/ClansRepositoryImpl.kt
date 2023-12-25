package com.example.data.clans

import com.example.domain.clans.ClansRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClansRepositoryImpl @Inject constructor(private val clansApi: ClansApi) :
    ClansRepository {
    override suspend fun getAllCharacters(page: String) = clansApi.getAllClans(page)


}
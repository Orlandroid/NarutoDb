package com.example.data.villages

import com.example.domain.villages.VillagesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VillagesRepositoryImpl @Inject constructor(private val villagesApi: VillagesApi) :
    VillagesRepository {
    override suspend fun getAllVillages(page: String) = villagesApi.getAllVillages(page)

}
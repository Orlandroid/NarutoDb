package com.example.data.kara

import com.example.domain.kara.KaraRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KaraRepositoryImpl @Inject constructor(private val karaApi: KaraApi) :
    KaraRepository {
    override suspend fun getAllKara(page: String) = karaApi.getAllAkara(page)


}
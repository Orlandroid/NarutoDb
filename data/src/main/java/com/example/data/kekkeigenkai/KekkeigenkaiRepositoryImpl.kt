package com.example.data.kekkeigenkai

import com.example.domain.kekkeigenkai.KekkeigenkaiRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KekkeigenkaiRepositoryImpl @Inject constructor(private val kekkeigenkaiApi: KekkeigenkaiApi) :
    KekkeigenkaiRepository {
    override suspend fun getAllGenkais(page: String) = kekkeigenkaiApi.getAllKekkeigenkai(page)

}
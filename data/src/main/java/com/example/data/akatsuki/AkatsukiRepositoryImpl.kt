package com.example.data.akatsuki

import com.example.domain.akatsuki.AkatsukiRepository
import com.example.domain.akatsuki.AkatsukiResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AkatsukiRepositoryImpl @Inject constructor(private val akatsukiApi: AkatsukiApi) :
    AkatsukiRepository {
    override suspend fun getAllAkatsuki(page: String) = akatsukiApi.getAllAkatsuki(page)

}
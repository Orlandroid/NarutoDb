package com.example.data.tailedbeasts

import com.example.domain.tailedbeasts.TailedBeastsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TailedBeastsRepositoryImpl @Inject constructor(private val tailedBeastsApi: TailedBeastsApi) :
    TailedBeastsRepository {

    override suspend fun getAllTailedBeasts(page: String) = tailedBeastsApi.getAllTailedBeasts(page)

}
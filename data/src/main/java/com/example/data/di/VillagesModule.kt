package com.example.data.di

import com.example.data.villages.VillagesApi
import com.example.data.villages.VillagesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object VillagesModule {


    @Singleton
    @Provides
    fun provideClansApi(retrofit: Retrofit): VillagesApi =
        retrofit.create(VillagesApi::class.java)

    @Provides
    @Singleton
    fun provideVillagesRepository(
        villagesApi: VillagesApi,
    ) = VillagesRepositoryImpl(villagesApi)
}
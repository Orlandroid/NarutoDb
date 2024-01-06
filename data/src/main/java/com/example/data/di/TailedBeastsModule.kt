package com.example.data.di

import com.example.data.tailedbeasts.TailedBeastsApi
import com.example.data.tailedbeasts.TailedBeastsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object TailedBeastsModule {


    @Singleton
    @Provides
    fun provideTailedBeastsApi(retrofit: Retrofit): TailedBeastsApi =
        retrofit.create(TailedBeastsApi::class.java)

    @Provides
    @Singleton
    fun provideTailedBeastsRepository(
        tailedBeastsApi: TailedBeastsApi,
    ) = TailedBeastsRepositoryImpl(tailedBeastsApi)
}
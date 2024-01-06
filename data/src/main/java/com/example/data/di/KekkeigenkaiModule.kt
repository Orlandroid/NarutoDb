package com.example.data.di

import com.example.data.kekkeigenkai.KekkeigenkaiApi
import com.example.data.kekkeigenkai.KekkeigenkaiRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object KekkeigenkaiModule {


    @Singleton
    @Provides
    fun provideKekkeigenkaiApi(retrofit: Retrofit): KekkeigenkaiApi =
        retrofit.create(KekkeigenkaiApi::class.java)

    @Provides
    @Singleton
    fun provideKekkeigenkaiRepository(
        kekkeigenkaiApi: KekkeigenkaiApi,
    ) = KekkeigenkaiRepositoryImpl(kekkeigenkaiApi)
}
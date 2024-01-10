package com.example.data.di

import com.example.data.kara.KaraApi
import com.example.data.kara.KaraRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object KaraModule {


    @Singleton
    @Provides
    fun provideKaraApi(retrofit: Retrofit): KaraApi =
        retrofit.create(KaraApi::class.java)

    @Provides
    @Singleton
    fun provideKaraRepository(
        karaApi: KaraApi,
    ) = KaraRepositoryImpl(karaApi)
}
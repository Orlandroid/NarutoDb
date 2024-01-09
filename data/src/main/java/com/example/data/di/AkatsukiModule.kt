package com.example.data.di

import com.example.data.akatsuki.AkatsukiApi
import com.example.data.akatsuki.AkatsukiRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object AkatsukiModule {


    @Singleton
    @Provides
    fun provideAkatsukiApi(retrofit: Retrofit): AkatsukiApi =
        retrofit.create(AkatsukiApi::class.java)

    @Provides
    @Singleton
    fun provideAkatsukiRepository(
        akatsukiApi: AkatsukiApi,
    ) = AkatsukiRepositoryImpl(akatsukiApi)
}
package com.example.data.di

import com.example.data.clans.ClansApi
import com.example.data.clans.ClansRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object ClansModule {


    @Singleton
    @Provides
    fun provideClansApi(retrofit: Retrofit) = retrofit.create(ClansApi::class.java)

    @Provides
    @Singleton
    fun provideClansRepository(
        clansApi: ClansApi,
    ) = ClansRepositoryImpl(clansApi)
}
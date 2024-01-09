package com.example.data.di

import com.example.data.teams.TeamsApi
import com.example.data.teams.TeamsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object TeamsModule {


    @Singleton
    @Provides
    fun provideTeamsApi(retrofit: Retrofit): TeamsApi =
        retrofit.create(TeamsApi::class.java)

    @Provides
    @Singleton
    fun provideTeamsRepository(
        teamsApi: TeamsApi,
    ) = TeamsRepositoryImpl(teamsApi)
}
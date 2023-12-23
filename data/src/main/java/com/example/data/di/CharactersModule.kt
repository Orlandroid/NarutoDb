package com.example.data.di

import com.example.data.characters.CharactersApi
import com.example.data.characters.CharactersRepositoryImpl
import com.example.domain.characters.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object CharactersModule {


    @Singleton
    @Provides
    fun provideCharacterApi(retrofit: Retrofit): CharactersApi =
        retrofit.create(CharactersApi::class.java)

    @Provides
    @Singleton
    fun characterRepository(
        charactersApi: CharactersApi,
    ): CharactersRepository = CharactersRepositoryImpl(charactersApi)
}
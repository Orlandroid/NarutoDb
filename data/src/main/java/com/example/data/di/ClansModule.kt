package com.example.data.di

import com.example.data.clans.ClansApi
import com.example.data.clans.ClansRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object ClansModule {

    private const val CLANS = "Clans"
    private const val BASE_URL_CLANS = "https://naruto-api-rsl3.onrender.com/api/v1/clans/"

    @Singleton
    @Provides
    @Named(CLANS)
    fun provideRetrofitClans(okHttpClient: OkHttpClient): Retrofit = provideRetrofitGeneric(
        okHttpClient = okHttpClient,
        baseUrl = BASE_URL_CLANS
    )

    @Singleton
    @Provides
    fun provideClansApi(@Named(CLANS) retrofit: Retrofit): ClansApi =
        retrofit.create(ClansApi::class.java)

    @Provides
    @Singleton
    fun provideClansRepository(
        clansApi: ClansApi,
    ) = ClansRepositoryImpl(clansApi)
}
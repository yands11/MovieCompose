package com.dot2line.moviecompose.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(value = [SingletonComponent::class])
object NetworkModule {

    @Provides
    fun provideBaseUrl(): String =
        "https://api.themoviedb.org/3/"

    @Provides
    fun provideConverterFactory(): Converter.Factory =
        Json { ignoreUnknownKeys = true }
            .asConverterFactory("application/json".toMediaTypeOrNull()!!)

    @Provides
    @Singleton
    fun provideRetrofit(
        baseUrl: String,
        converterFactory: Converter.Factory,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .build()
}

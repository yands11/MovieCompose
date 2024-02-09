package com.dot2line.moviecompose.di

import com.dot2line.moviecompose.data.network.TmdbService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(value = [SingletonComponent::class])
object ServiceModule {

    @Provides
    @Singleton
    fun provideTmdbService(retrofit: Retrofit): TmdbService =
        retrofit.create(TmdbService::class.java)

}

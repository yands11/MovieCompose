package com.dot2line.moviecompose.di

import com.dot2line.moviecompose.data.network.TmdbService
import com.dot2line.moviecompose.data.repository.MovieRepositoryImpl
import com.dot2line.moviecompose.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(value = [SingletonComponent::class])
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        tmdbService: TmdbService,
    ): MovieRepository = MovieRepositoryImpl(tmdbService)
}

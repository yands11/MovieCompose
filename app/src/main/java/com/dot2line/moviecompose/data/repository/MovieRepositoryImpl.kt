package com.dot2line.moviecompose.data.repository

import android.util.Log
import com.dot2line.moviecompose.data.network.TmdbService
import com.dot2line.moviecompose.data.toMovie
import com.dot2line.moviecompose.data.value
import com.dot2line.moviecompose.domain.model.Genre
import com.dot2line.moviecompose.domain.model.Movie
import com.dot2line.moviecompose.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val tmdbService: TmdbService,
) : MovieRepository {
    override suspend fun getMovies(genre: Genre): List<Movie> {
        val response = tmdbService.discoverMovie(genre = genre.value, page = 1)
        val movies = response.results.map { result -> result.toMovie() }
        return movies
    }
}

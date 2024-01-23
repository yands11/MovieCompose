package com.dot2line.moviecompose.data.repository

import android.util.Log
import com.dot2line.moviecompose.data.network.TmdbApi
import com.dot2line.moviecompose.data.toMovie
import com.dot2line.moviecompose.data.value
import com.dot2line.moviecompose.domain.model.Genre
import com.dot2line.moviecompose.domain.model.Movie
import com.dot2line.moviecompose.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val tmdbApi: TmdbApi,
) : MovieRepository {
    override suspend fun getMovies(genre: Genre): List<Movie> {
        val response = tmdbApi.discoverMovie(genre = genre.value, page = 1)
        val movies = response.results.map { result -> result.toMovie() }
        Log.d("Test", movies.toString())
        return movies
    }
}

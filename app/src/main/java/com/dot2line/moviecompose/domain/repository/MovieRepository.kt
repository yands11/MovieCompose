package com.dot2line.moviecompose.domain.repository

import com.dot2line.moviecompose.domain.model.Genre
import com.dot2line.moviecompose.domain.model.Movie

interface MovieRepository {

    suspend fun getMovies(genre: Genre): List<Movie>

}

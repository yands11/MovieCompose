package com.dot2line.moviecompose.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dot2line.moviecompose.domain.model.Genre
import com.dot2line.moviecompose.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MovieRepository,
) : ViewModel() {

    fun fetchMovies() {
        viewModelScope.launch {
            val a = repository.getMovies(genre = Genre.ADVENTURE)
            Log.d("TEST", a.toString())
        }
    }

}

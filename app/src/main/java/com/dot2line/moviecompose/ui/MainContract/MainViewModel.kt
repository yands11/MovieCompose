package com.dot2line.moviecompose.ui.MainContract

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dot2line.moviecompose.domain.model.Genre
import com.dot2line.moviecompose.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MovieRepository,
) : ViewModel() {

    private val _event: MutableSharedFlow<MainEvent> = MutableSharedFlow()
    val event: SharedFlow<MainEvent> = _event.asSharedFlow()

    private val _effect: Channel<MainEffect> = Channel()
    val effect: Flow<MainEffect> = _effect.receiveAsFlow()

    private val _state = MutableStateFlow(MainState())
    val state: StateFlow<MainState> = _state.asStateFlow()

    init {
        observeEvent()
        observeMovies()
    }

    private fun observeEvent() {
        viewModelScope.launch {
            event.collect { handleEvent(it) }
        }
    }

    private fun handleEvent(event: MainEvent) {
    }

    fun submitEvent(event: MainEvent) {
        viewModelScope.launch { _event.emit(event) }
    }

    private fun reduceState(reducer: MainState.() -> MainState) {
        _state.value = _state.value.reducer()
    }

    private fun observeMovies() {
        viewModelScope.launch {
            val movies = repository.getMovies(genre = Genre.ADVENTURE)
            reduceState { copy(movies = movies.map { it.toUiModel() }) }
        }
    }
}

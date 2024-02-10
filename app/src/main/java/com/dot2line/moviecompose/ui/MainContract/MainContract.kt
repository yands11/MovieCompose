package com.dot2line.moviecompose.ui.MainContract

import com.dot2line.moviecompose.ui.common.Effect
import com.dot2line.moviecompose.ui.common.Event
import com.dot2line.moviecompose.ui.common.State

data class MainState(
    val movies: List<MovieUiModel> = listOf(),
) : State

sealed interface MainEvent : Event

sealed interface MainEffect : Effect




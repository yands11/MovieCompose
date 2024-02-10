package com.dot2line.moviecompose.ui.MainContract

import com.dot2line.moviecompose.domain.model.Movie

data class MovieUiModel(
    val id: Int,
    val title: String,
    val posterUrl: String,
)

fun Movie.toUiModel(): MovieUiModel {
    return MovieUiModel(
        id = id,
        title = title.translated,
        posterUrl = posterImgUrl
    )
}


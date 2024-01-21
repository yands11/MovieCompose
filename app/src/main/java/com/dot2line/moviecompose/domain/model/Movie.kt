package com.dot2line.moviecompose.domain.model

import java.util.Date

data class Movie(
    val id: Int,
    val title: Title,
    val overview: String,
    val posterImgUrl: String,
    val vote: Vote,
    val genres: List<Genre>,
    val releaseDate: Date,
    val isAdult: Boolean,
)

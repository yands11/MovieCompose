package com.dot2line.moviecompose.data

import com.dot2line.moviecompose.data.model.MovieResult
import com.dot2line.moviecompose.domain.model.Genre
import com.dot2line.moviecompose.domain.model.Movie
import com.dot2line.moviecompose.domain.model.Title
import com.dot2line.moviecompose.domain.model.Vote
import java.text.SimpleDateFormat
import java.util.Date

fun Int.toGenre(): Genre {
    return when (this) {
        28 -> Genre.ACTION
        12 -> Genre.ADVENTURE
        16 -> Genre.ANIMATION
        35 -> Genre.COMEDY
        80 -> Genre.CRIME
        99 -> Genre.DOCUMENTARY
        18 -> Genre.DRAMA
        10751 -> Genre.FAMILY
        14 -> Genre.FANTASY
        36 -> Genre.HISTORY
        27 -> Genre.HORROR
        10402 -> Genre.MUSIC
        9648 -> Genre.MYSTERY
        10749 -> Genre.ROMANCE
        878 -> Genre.SCIENCE_FICTION
        10770 -> Genre.TV_MOVIE
        53 -> Genre.THRILLER
        10752 -> Genre.WAR
        37 -> Genre.WESTERN
        else -> Genre.NONE
    }
}

val Genre.value: Int
    get() = when (this) {
        Genre.NONE -> 0
        Genre.ACTION -> 28
        Genre.ADVENTURE -> 12
        Genre.ANIMATION -> 16
        Genre.COMEDY -> 35
        Genre.CRIME -> 80
        Genre.DOCUMENTARY -> 99
        Genre.DRAMA -> 18
        Genre.FAMILY -> 10751
        Genre.FANTASY -> 14
        Genre.HISTORY -> 36
        Genre.HORROR -> 27
        Genre.MUSIC -> 10402
        Genre.MYSTERY -> 9648
        Genre.ROMANCE -> 10749
        Genre.SCIENCE_FICTION -> 878
        Genre.TV_MOVIE -> 10770
        Genre.THRILLER -> 53
        Genre.WAR -> 10752
        Genre.WESTERN -> 37
    }

fun MovieResult.toMovie(): Movie = Movie(
    id = id,
    title = Title(original = originalTitle, translated = title),
    overview = overview,
    posterImgUrl = "https://media.themoviedb.org/t/p/w440_and_h660_face${posterPath}",
    vote = Vote(voteAverage, voteCount),
    genres = genres.map { it.toGenre() },
    releaseDate = SimpleDateFormat("yyyy-MM-dd").parse(releaseDate),
    isAdult = isAdult
)

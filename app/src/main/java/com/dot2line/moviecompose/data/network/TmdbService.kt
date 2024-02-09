package com.dot2line.moviecompose.data.network

import com.dot2line.moviecompose.data.model.DiscoverResult
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbService {

    @GET("discover/movie")
    suspend fun discoverMovie(
        @Query("api_key") apiKey: String = "b5c64b56f0875023649a6d7631006845",
        @Query("watch_region") watchRegion: String = "KR",
        @Query("language") language: String = "ko",
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("with_genres") genre: Int,
        @Query("page") page: Int,
    ): DiscoverResult

}

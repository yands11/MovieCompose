package com.dot2line.moviecompose.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

object NetworkModule {

    val baseUrl = "https://api.themoviedb.org/3/"
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(Json {
            ignoreUnknownKeys = true
        }.asConverterFactory(MediaType.parse("application/json")!!))
        .build()

    val tmdbApi = retrofit.create(TmdbApi::class.java)
}

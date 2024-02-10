package com.dot2line.moviecompose.ui.MainContract

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.dot2line.moviecompose.ui.theme.MovieComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieComposeTheme {
                val state by vm.state.collectAsStateWithLifecycle()
                MovieList(state.movies)
            }
        }
    }
}

@Composable
fun MovieList(movies: List<MovieUiModel>, modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(top = 16.dp)
    ) {
        items(
            items = movies,
            key = { it.id }
        ) {
            MovieItem(it)
        }
    }
}

@Composable
fun MovieItem(movie: MovieUiModel, modifier: Modifier = Modifier) {
    Column {
        AsyncImage(model = movie.posterUrl, contentDescription = null)
        Text(text = movie.title)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieComposeTheme {
    }
}

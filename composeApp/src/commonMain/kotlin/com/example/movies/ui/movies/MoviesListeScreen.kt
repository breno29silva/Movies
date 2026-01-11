package com.example.movies.ui.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movies.domain.model.movie1
import com.example.movies.ui.componenets.MovieSection
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MoviesListRoute() {
    MoviesListScreen()
}

@Preview(showBackground = true)
@Composable
fun MoviesListScreenPreview() {
    MoviesListScreen()
}

@Composable
fun MoviesListScreen() {
    Scaffold(modifier = Modifier) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            item {
                MovieSection(title = "Popular movies", movies = List(10) { movie1 })
            }
            item {
                MovieSection(
                    title = "Top Rated Movies",
                    movies = List(10) { movie1 })
            }
            item {
                MovieSection(
                    title = "Upcoming Movies",
                    movies = List(10) { movie1 })
            }
        }
    }
}


package com.example.movies.ui.moviedetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movies.domain.model.Movie
import com.example.movies.domain.model.movie1
import com.example.movies.ui.theme.MoviesAppTheme
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ArrowLeft
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MovieDetailRoute() {
}

@Preview(showBackground = true)
@Composable
fun MovieDetailScreenPreview() {
    MoviesAppTheme {
        MovieDetailScreen(movie = movie1)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(movie: Movie) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text("Movie details") },
            navigationIcon = {
                Surface(
                    modifier = Modifier.padding(start = 16.dp),
                    shape = MaterialTheme.shapes.small
                ) {
                    IconButton(modifier = Modifier.size(32.dp), onClick = {}) {
                        Icon(
                            modifier = Modifier.padding(8.dp),
                            imageVector = FontAwesomeIcons.Solid.ArrowLeft,
                            contentDescription = null
                        )
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
        )
    }) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {

        }
    }
}


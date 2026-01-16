package com.example.movies.ui.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.movies.domain.model.MovieSection
import com.example.movies.domain.model.movie1
import com.example.movies.ui.componenets.MoviesSection
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MoviesListRoute(
    viewModel: MoviesListViewModel = koinViewModel(),
    navigateToMovieDetail: (movieId: Int) -> Unit
) {
    val moviesListState by viewModel.moviesListState.collectAsStateWithLifecycle()

    MoviesListScreen(moviesListState = moviesListState, onMoviePostClick = navigateToMovieDetail)
}

@Preview(showBackground = true)
@Composable
fun MoviesListScreenPreview() {
    val successState = MoviesListViewModel.MoviesListState.Success(
        movieSections = listOf(
            MovieSection(
                sectionTypeEnum = MovieSection.SectionTypeEnum.POPULAR,
                movies = listOf(movie1, movie1)
            )
        )
    )
    val errorState = MoviesListViewModel.MoviesListState.Error(message = "Fail")
    val loadingState = MoviesListViewModel.MoviesListState.Loading
    MoviesListScreen(moviesListState = successState, onMoviePostClick = {})
}

@Composable
fun MoviesListScreen(moviesListState: MoviesListViewModel.MoviesListState, onMoviePostClick: (moveId: Int) -> Unit) {
    Scaffold(modifier = Modifier) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            when (moviesListState) {
                MoviesListViewModel.MoviesListState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

                is MoviesListViewModel.MoviesListState.Success -> {

                    LazyColumn(
                        contentPadding = PaddingValues(vertical = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(32.dp)
                    ) {
                        items(moviesListState.movieSections) { item ->
                            MoviesSection(
                                title = stringResource(item.sectionTypeEnum.titleRes),
                                movies = item.movies,
                                onMoviePostClick = onMoviePostClick
                            )
                        }
                    }
                }

                is MoviesListViewModel.MoviesListState.Error -> {
                    Text(
                        text = moviesListState.message,
                        modifier = Modifier.align(Alignment.Center).padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}


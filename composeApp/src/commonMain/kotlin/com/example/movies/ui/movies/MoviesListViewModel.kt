package com.example.movies.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.repository.MoviesRepository
import com.example.movies.domain.model.MovieSection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

//TODO Add interface
class MoviesListViewModel(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    sealed interface MoviesListState {
        data object Loading : MoviesListState
        data class Success(val movieSections: List<MovieSection>) : MoviesListState
        data class Error(val message: String) : MoviesListState
    }

    private val _moviesListState = MutableStateFlow<MoviesListState>(MoviesListState.Loading)
    val moviesListState = _moviesListState.asStateFlow()

    init {
        getMoviesSection()
    }

    private fun getMoviesSection() {
        viewModelScope.launch {
            try {
                val response = moviesRepository.getMovieSections()
                _moviesListState.update {
                    MoviesListState.Success(movieSections = response)
                }
            } catch (e: Exception) {
                _moviesListState.update {
                    MoviesListState.Error(message = e.message ?: "")
                }
            }
        }
    }
}
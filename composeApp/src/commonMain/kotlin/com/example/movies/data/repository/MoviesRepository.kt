package com.example.movies.data.repository

import com.example.movies.data.network.KtorClient
import com.example.movies.domain.model.MovieSection
import com.example.movies.domain.model.toModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class MoviesRepository(private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) {

    suspend fun getMovieSections(): List<MovieSection> {
        return withContext(ioDispatcher) {

            val popularMoviesDeferred = async { KtorClient.getMovies("popular") }
            val topRatedMoviesDeferred = async { KtorClient.getMovies("top_rated") }
            val upcomingMoviesDeferred = async { KtorClient.getMovies("upcoming") }

            val popularMovies = popularMoviesDeferred.await()
            val topRateMovies = topRatedMoviesDeferred.await()
            val upcomingMovies = upcomingMoviesDeferred.await()

            listOf(
                MovieSection(
                    sectionTypeEnum = MovieSection.SectionTypeEnum.POPULAR,
                    movies = popularMovies.toModel()
                ),
                MovieSection(
                    sectionTypeEnum = MovieSection.SectionTypeEnum.TOP_RATED,
                    movies = topRateMovies.toModel()
                ),
                MovieSection(
                    sectionTypeEnum = MovieSection.SectionTypeEnum.UPCOMING,
                    movies = upcomingMovies.toModel()
                )
            )
        }
    }
}
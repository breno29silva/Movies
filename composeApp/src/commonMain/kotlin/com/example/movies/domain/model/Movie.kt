package com.example.movies.domain.model

import com.example.movies.data.network.IMAGE_SMALL_BASE_URL
import com.example.movies.data.network.model.MovieResponse
import com.example.movies.data.network.model.MoviesListResponse

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val postUrl: String
)

fun MovieResponse.toModel(): Movie {
    return Movie(
        id = this.id,
        title = this.title,
        overview = this.overview,
        postUrl = "$IMAGE_SMALL_BASE_URL${this.posterPath}"
    )
}

fun MoviesListResponse.toModel(): List<Movie> {
    return this.results.map { it.toModel() }
}

// fake objects
val movie1 = Movie(
    id = 1,
    title = "title",
    overview = "overview",
    postUrl = "postUrl"
)
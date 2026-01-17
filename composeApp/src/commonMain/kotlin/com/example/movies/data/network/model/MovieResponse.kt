package com.example.movies.data.network.model

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("poster_path") val posterPath: String,
    val genres: List<GenreResponse>? = null,
    @SerialName("release_date") val releaseDate: LocalDate? = null,
    val runtime: Int? = null,
    @SerialName("vote_average") val voteAverage: Double
)

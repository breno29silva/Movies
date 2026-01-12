package com.example.movies.domain.model

import movies.composeapp.generated.resources.Res
import movies.composeapp.generated.resources.movies_list_popular_movies
import movies.composeapp.generated.resources.movies_list_top_rated_movies
import movies.composeapp.generated.resources.movies_list_upcoming_movies
import org.jetbrains.compose.resources.StringResource

data class MovieSection(val sectionTypeEnum: SectionTypeEnum, val movies: List<Movie>) {

    enum class SectionTypeEnum(val titleRes: StringResource) {
        POPULAR(Res.string.movies_list_popular_movies),
        TOP_RATED(Res.string.movies_list_top_rated_movies),
        UPCOMING(Res.string.movies_list_upcoming_movies)
    }
}
package com.example.movies.domain.model

data class MovieSection(val sectionTypeEnum: SectionTypeEnum, val movies: List<Movie>) {

    enum class SectionTypeEnum(val title: String) {
        POPULAR("Popular Movies"),
        TOP_RATED("Top Rated Movies"),
        UPCOMING("Upcoming Movies")
    }
}
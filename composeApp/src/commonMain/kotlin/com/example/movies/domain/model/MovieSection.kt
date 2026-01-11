package com.example.movies.domain.model

data class MovieSection(val sectionTypeEnum: SectionTypeEnum, val movies: List<Movie>) {

    enum class SectionTypeEnum {
        POPULAR,
        TOP_RATED,
        UPCOMING
    }
}
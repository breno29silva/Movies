package com.example.movies.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val postUrl: String
)

// fake objects
val movie1 = Movie(
    id = 1,
    title = "title",
    overview = "overview",
    postUrl = "postUrl"
)

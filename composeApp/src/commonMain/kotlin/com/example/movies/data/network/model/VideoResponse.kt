package com.example.movies.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class VideoResponse(
    val id: String,
    val name: String,
    val key: String,
    val site: String,
    val type: String,
    val official: Boolean,
)

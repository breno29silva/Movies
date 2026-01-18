package com.example.movies.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class VideosListResponse(
    val id: Int,
    val results: List<VideoResponse>,
)
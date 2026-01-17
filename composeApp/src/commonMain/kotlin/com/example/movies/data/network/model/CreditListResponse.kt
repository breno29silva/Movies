package com.example.movies.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CreditListResponse(val id: Int, val cast: List<CastMemberResponse>)

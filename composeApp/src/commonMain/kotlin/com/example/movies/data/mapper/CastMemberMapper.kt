package com.example.movies.data.mapper

import com.example.movies.data.network.IMAGE_BASE_URL
import com.example.movies.data.network.model.CastMemberResponse
import com.example.movies.domain.enum.ImageSizeEnum
import com.example.movies.domain.model.CastMember

fun CastMemberResponse.toModel() = CastMember(
    id = this.id,
    mainRole = this.department,
    name = this.name,
    character = this.character,
    profileUrl = "$IMAGE_BASE_URL/${ImageSizeEnum.SMALL.size}/${this.profilePath}"
)
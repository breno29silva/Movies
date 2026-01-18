package com.example.movies.data.mapper


import com.example.movies.data.network.IMAGE_BASE_URL
import com.example.movies.data.network.model.CastMemberResponse
import com.example.movies.data.network.model.MovieResponse
import com.example.movies.data.network.model.MoviesListResponse
import com.example.movies.domain.enum.ImageSizeEnum
import com.example.movies.domain.model.Movie
import com.example.movies.utils.formatRating
import kotlin.math.roundToInt


fun MovieResponse.toModel(
    castMembersResponse: List<CastMemberResponse>? = null,
    imageSize: ImageSizeEnum = ImageSizeEnum.SMALL,
    movieTrailerYoutubeKey: String? = null,
): Movie {
    return Movie(
        id = this.id,
        title = this.title,
        overview = this.overview,
        postUrl = "$IMAGE_BASE_URL/${imageSize.size}/${this.posterPath}",
        genres = this.genres?.map { it.toModel() },
        year = this.getYearFromReleaseDate(),
        duration = this.getDurationInHoursAndMinutes(),
        rating = this.voteAverage.formatRating(),
        movieTrailerYoutubeKey = movieTrailerYoutubeKey,
        castMemberList = castMembersResponse
            ?.filter { it.department == "Acting" }
            ?.take(20)
            ?.map { it.toModel() },
    )
}

fun MoviesListResponse.toModel(): List<Movie> {
    return this.results.map { it.toModel() }
}

private fun MovieResponse.getYearFromReleaseDate(): Int {
    return this.releaseDate?.year ?: 0
}

private fun MovieResponse.getDurationInHoursAndMinutes(): String? {
    return this.runtime?.let { runtimeMinutes ->
        val hours = runtimeMinutes / 60
        val minutes = runtimeMinutes % 60

        buildString {
            if (hours > 0) {
                append("${hours}h ")
            }

            append("${minutes}min")
        }
    }
}
package model

import com.google.gson.annotations.SerializedName

data class Movie(

    @SerializedName("poster_path")
    var posterPath: String,
    var adult: Boolean,
    var overview: String,
    @SerializedName("release_date")
    var releaseDate: String,
    var genre_ids: List<Int>,
    var id: Long,
    @SerializedName("originalTitle")
    var originalTitle: String,
    @SerializedName("original_language")
    var originalLanguage: String,
    var title: String,
    @SerializedName("backdrop_path")
    var backdropPath: String,
    var popularity: Double,
    @SerializedName("vote_count")
    var voteCount: Int,
    var video: Boolean,
    @SerializedName("vote_average")
    var voteAverage: Double
)
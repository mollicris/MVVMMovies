package com.example.tmdbclient.data.model.movie
import com.example.tmdbclient.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val results: List<Movie>
)
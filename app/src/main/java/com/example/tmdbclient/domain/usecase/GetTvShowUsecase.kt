package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.domain.repository.TvShowsRepository

class GetTvShowUsecase(private val tvShowsRepository: TvShowsRepository) {

    suspend fun getMovies():List<TvShow>? = tvShowsRepository.getTvShows()
}
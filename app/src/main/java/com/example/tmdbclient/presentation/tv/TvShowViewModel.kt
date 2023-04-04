package com.example.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.GetTvShowUsecase
import com.example.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowUsecase: GetTvShowUsecase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShow() = liveData {
        val tvList = getTvShowUsecase.execute()
        emit(tvList)
    }

    fun updateTvShow() = liveData {
        val tvList = updateTvShowsUseCase.execute()
        emit(tvList)
    }
}
package com.example.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistUsecase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistUsecase: UpdateArtistUsecase
): ViewModel() {

    fun getArtist() = liveData{
        val artist = getArtistsUseCase.execute()
        emit(artist)
    }

    fun updateArtist() = liveData {
        val artist = updateArtistUsecase.execute()
        emit(artist)
    }

}
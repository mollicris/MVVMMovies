package com.example.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistUsecase

class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private  val updateArtistUsecase: UpdateArtistUsecase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase,updateArtistUsecase) as T
    }
}
package com.example.tmdbclient.presentation.di.tvshow

import com.example.tmdbclient.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.domain.usecase.GetTvShowUsecase
import com.example.tmdbclient.domain.usecase.UpdateArtistUsecase
import com.example.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.example.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.example.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideArtistViewModelFactory(
        getTvShowUseCase: GetTvShowUsecase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory{
        return TvShowViewModelFactory(getTvShowUseCase,updateTvShowsUseCase)
    }
}
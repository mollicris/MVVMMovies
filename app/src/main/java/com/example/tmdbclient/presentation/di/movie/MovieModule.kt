package com.example.tmdbclient.presentation.di.movie

import com.example.tmdbclient.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistUsecase
import com.example.tmdbclient.domain.usecase.UpdateMoviesUsecase
import com.example.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.example.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUsecase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase,updateMoviesUseCase)
    }
}
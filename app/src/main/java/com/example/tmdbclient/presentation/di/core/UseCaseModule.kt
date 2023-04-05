package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.domain.repository.ArtistRepository
import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.domain.repository.TvShowsRepository
import com.example.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun providerGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun providerUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUsecase{
        return UpdateMoviesUsecase(movieRepository)
    }

    @Provides
    fun providerGetTvShowUseCase(tvShowsRepository: TvShowsRepository): GetTvShowUsecase{
        return GetTvShowUsecase(tvShowsRepository)
    }

    @Provides
    fun providerUpdateTvShowUseCase(tvShowsRepository: TvShowsRepository): UpdateTvShowsUseCase{
        return UpdateTvShowsUseCase(tvShowsRepository)
    }

    @Provides
    fun providerGetArtistUseCase(artistRepository: ArtistRepository): GetArtistsUseCase{
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun providerUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUsecase{
        return UpdateArtistUsecase(artistRepository)
    }

}
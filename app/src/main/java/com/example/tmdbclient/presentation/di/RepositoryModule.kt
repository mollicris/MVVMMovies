package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import dagger.Module

@Module
class RepositoryModule {

    fun provideMovieRepository(
       movieRemoteDataSource: MovieRemoteDataSource,
       movieLocalDataSource: MovieLocalDataSource,
       movieCacheDataSource: MovieCacheDataSource
    ){

    }
}
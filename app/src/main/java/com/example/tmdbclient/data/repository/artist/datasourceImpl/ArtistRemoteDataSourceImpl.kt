package com.example.tmdbclient.data.repository.artist.datasourceImpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmbdService:TMDBService,
    private val apikey:String) : ArtistRemoteDataSource {
    override suspend fun getArtist(): Response<ArtistList> {
        return tmbdService.getPopularArtist(apikey)
    }
}
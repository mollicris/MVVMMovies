package com.example.tmdbclient.data.repository.tvshow.datasource

import com.example.tmdbclient.data.model.tvshow.TvShow
import retrofit2.Response

interface TvshowRemoteDataSource {

    suspend fun getTvshow() : Response<TvShow>

}
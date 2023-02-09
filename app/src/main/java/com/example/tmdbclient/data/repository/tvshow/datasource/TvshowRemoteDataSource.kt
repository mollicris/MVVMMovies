package com.example.tmdbclient.data.repository.tvshow.datasource

import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvshowRemoteDataSource {

    suspend fun getTvshow() : Response<TvShowList>

}
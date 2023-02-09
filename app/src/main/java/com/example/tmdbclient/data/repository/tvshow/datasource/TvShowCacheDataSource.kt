package com.example.tmdbclient.data.repository.tvshow.datasource

import com.example.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache() : List<TvShow>
    suspend fun saveTvShowToCache(tvShowList: List<TvShow>)
}
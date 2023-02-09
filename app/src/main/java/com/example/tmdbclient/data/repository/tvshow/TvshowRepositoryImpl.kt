package com.example.tmdbclient.data.repository.tvshow

import android.util.Log
import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.data.model.tvshow.TvShowList
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvshowRemoteDataSource
import com.example.tmdbclient.domain.repository.TvShowsRepository
import retrofit2.Response

class TvshowRepositoryImpl(
    private val tvShowRemoteDataSource: TvshowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowsRepository
{
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newLisTvShow : List<TvShow> = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newLisTvShow)
        tvShowCacheDataSource.saveTvShowToCache(newLisTvShow)
        return newLisTvShow
    }

    suspend fun getTvShowsFromAPI():List<TvShow>{
        lateinit var movieList:List<TvShow>
        try {
            val response : Response<TvShowList> = tvShowRemoteDataSource.getTvshow()
            val body : TvShowList? = response.body()
            if (body!=null){
                movieList = body.tvShows
            }
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return movieList
    }

    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }

        if(tvShowList.size > 0){
            return  tvShowList
        }else{
            tvShowList=getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow>{
        lateinit var TvShowList:List<TvShow>
        try {
            TvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }

        if(TvShowList.isNotEmpty()){
            return  TvShowList
        }else{
            TvShowList=getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowToCache(TvShowList)
        }

        return TvShowList
    }
}
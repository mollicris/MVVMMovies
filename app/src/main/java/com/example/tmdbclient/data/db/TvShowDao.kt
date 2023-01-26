package com.example.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.model.tvshow.TvShow

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(tvShowsList: List<TvShow>)

    @Query("DELETE FROM popular_tvshow")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tvshow")
    suspend fun getTvShow(): List<TvShow>
}
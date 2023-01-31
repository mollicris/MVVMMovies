package com.example.tmdbclient.data.repository.artist

import android.util.Log
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.domain.repository.ArtistRepository
import retrofit2.Response

class ArtistRepositoryImpl(
    private val artistCacheDataSource: ArtistCacheDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistRemoteDataSource: ArtistRemoteDataSource
): ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newListArtis:List<Artist> = getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtist(newListArtis)
        artistCacheDataSource.saveArtistToCache(newListArtis)
        return newListArtis
    }

    suspend fun getArtistFromAPI(): List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            val response : Response<ArtistList> = artistRemoteDataSource.getArtist()
            val body : ArtistList? = response.body()
            if (body!=null){
                artistList = body.artists
            }
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromBD(): List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            artistList = artistLocalDataSource.getArtist()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }

        if(artistList.size > 0){
            return  artistList
        }else{
            artistList=getArtistFromAPI()
            artistLocalDataSource.saveArtist(artistList)
        }

        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }

        if(artistList.size > 0){
            return  artistList
        }else{
            artistList=getArtistFromBD()
            artistCacheDataSource.saveArtistToCache(artistList)
        }

        return artistList
    }
}
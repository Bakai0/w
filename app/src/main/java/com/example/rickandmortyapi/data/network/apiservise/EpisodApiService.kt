package com.example.rickandmortyapi.data.network.apiservise

import com.example.rickandmortyapi.model.EpisodeModel
import com.example.rickandmortyapi.model.RickAndMortyResponce
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodApiService {

    @GET("/api/episode")
    fun fetchEpisodes(
//        @Query("page") page : Int
    ): Call<RickAndMortyResponce<EpisodeModel>>

    @GET("/api/episode/{id}")
    fun fetchDetailEpisode(@Path("id") id : Int):Call<EpisodeModel>
}
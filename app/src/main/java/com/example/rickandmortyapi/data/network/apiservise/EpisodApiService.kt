package com.example.rickandmortyapi.data.network.apiservise

import com.example.rickandmortyapi.model.EpisodeModel
import com.example.rickandmortyapi.model.RickAndMortyResponce
import retrofit2.Call
import retrofit2.http.GET

interface EpisodApiService {
    @GET("api/episode")
    fun fetchEpisode(): Call<RickAndMortyResponce<EpisodeModel>>
}
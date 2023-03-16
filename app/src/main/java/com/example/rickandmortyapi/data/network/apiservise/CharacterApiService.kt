package com.example.rickandmortyapi.data.network.apiservise

import com.example.rickandmortyapi.model.CharacterModel
import com.example.rickandmortyapi.model.RickAndMortyResponce
import retrofit2.Call
import retrofit2.http.GET

interface CharacterApiService {
    @GET("api/character")
    fun fetchCHaracters(): Call<RickAndMortyResponce<CharacterModel>>
}
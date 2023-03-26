package com.example.rickandmortyapi.data.network.apiservise

import com.example.rickandmortyapi.model.CharacterModel
import com.example.rickandmortyapi.model.RickAndMortyResponce
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {
    @GET("/api/character")
    suspend fun fetchCHaracters(
        @Query("page") page : Int
    ): RickAndMortyResponce<CharacterModel>

    @GET("/api/character/{id}")
    fun fetchDetailCharacters(@Path("id") id : Int): Call<CharacterModel>
}
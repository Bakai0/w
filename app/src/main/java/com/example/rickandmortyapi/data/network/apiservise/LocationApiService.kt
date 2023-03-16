package com.example.rickandmortyapi.data.network.apiservise

import com.example.rickandmortyapi.model.LocationModel
import com.example.rickandmortyapi.model.RickAndMortyResponce
import retrofit2.Call
import retrofit2.http.GET


interface LocationApiService {
    @GET("api/location")
    fun fetchLocation(): Call<RickAndMortyResponce<LocationModel>>

}
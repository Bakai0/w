package com.example.rickandmortyapi.data.network.apiservise

import com.example.rickandmortyapi.model.LocationModel
import com.example.rickandmortyapi.model.RickAndMortyResponce
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface LocationApiService {

    @GET("/api/location")
    fun fetchLocation(
//        @Query("page") page : Int
    ): Call<RickAndMortyResponce<LocationModel>>

    @GET("/api/location/{id}")
    fun fetchDetailLocation(@Path("id") id : Int): Call<LocationModel>
}


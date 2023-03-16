package com.example.rickandmortyapi.data.network.apiservise

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(30,TimeUnit.SECONDS).readTimeout(30,TimeUnit.SECONDS)
        .writeTimeout(30,TimeUnit.SECONDS).build()

    val retrofitClient = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideCharacterApiService():CharacterApiService{
        return retrofitClient.create(CharacterApiService::class.java)
    }
    fun provideLocationApiServices(): LocationApiService{
        return retrofitClient.create(LocationApiService::class.java)
    }
    fun provideEpisodeApiServices(): EpisodApiService{
        return retrofitClient.create(EpisodApiService::class.java)
    }
}
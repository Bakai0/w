package com.example.rickandmortyapi

import android.app.Application
import com.example.rickandmortyapi.data.network.apiservise.CharacterApiService
import com.example.rickandmortyapi.data.network.apiservise.EpisodApiService
import com.example.rickandmortyapi.data.network.apiservise.LocationApiService
import com.example.rickandmortyapi.data.network.apiservise.RetrofitClient

class App:Application() {

    companion object {
        val retrofitClient = RetrofitClient()
        var characterApiServices: CharacterApiService? = null
        var locationApiService: LocationApiService? = null
        var episodeApiService: EpisodApiService? = null
    }

    override fun onCreate() {
        super.onCreate()
        characterApiServices = retrofitClient.provideCharacterApiService()
        locationApiService = retrofitClient.provideLocationApiServices()
        episodeApiService = retrofitClient.provideEpisodeApiServices()
    }
}
package com.example.rickandmortyapi.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.model.EpisodeModel
import com.example.rickandmortyapi.model.RickAndMortyResponce
import retrofit2.Call
import retrofit2.Response

class EpisodeViewModel : ViewModel() {
    fun fetchEpisode(): MutableLiveData<RickAndMortyResponce<EpisodeModel>> {
        val data: MutableLiveData<RickAndMortyResponce<EpisodeModel>> = MutableLiveData()
        App.episodeApiService?.fetchEpisode()
            ?.enqueue(object : retrofit2.Callback<RickAndMortyResponce<EpisodeModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponce<EpisodeModel>>,
                    response: Response<RickAndMortyResponce<EpisodeModel>>,
                ) {
                    response.body()?.let {
                        data.value = it
                    }
                }
                override fun onFailure(
                    call: Call<RickAndMortyResponce<EpisodeModel>>,
                    t: Throwable,
                ) {
                    data.value = null
                }
            })
        return data
    }
}

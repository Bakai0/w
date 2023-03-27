package com.example.rickandmortyapi.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.model.EpisodeModel
import com.example.rickandmortyapi.model.RickAndMortyResponce
import com.example.rickandmortyapi.repozitory.EpisodeRepozitory
import retrofit2.Call
import retrofit2.Response

class EpisodeViewModel : ViewModel() {

    private val episodeRepository = EpisodeRepozitory()

    fun fetchEpisode() = episodeRepository.fetchEpisode().cachedIn(viewModelScope)

    fun fetchDetailEpisode(id: Int): MutableLiveData<EpisodeModel> {
        return episodeRepository.fetchDetailEpisode(id)
    }
}

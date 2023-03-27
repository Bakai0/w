package com.example.rickandmortyapi.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapi.model.CharacterModel
import com.example.rickandmortyapi.model.EpisodeModel
import com.example.rickandmortyapi.repozitory.EpisodeRepozitory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val episodeRepository: EpisodeRepozitory
) : ViewModel() {

    fun fetchEpisodes() = episodeRepository.fetchEpisode()
//        .cachedIn(viewModelScope)

    fun fetchDetailEpisode(id: Int): MutableLiveData<EpisodeModel> {
        return episodeRepository.fetchDetailEpisode(id)
    }

    fun getAll() = episodeRepository.getAll()
}

package com.example.rickandmortyapi.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapi.model.EpisodeModel
import com.example.rickandmortyapi.model.LocationModel
import com.example.rickandmortyapi.repozitory.LocationRepozitory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationRepository: LocationRepozitory
) : ViewModel() {

    fun fetchLocations() = locationRepository.fetchLocation()
//        .cachedIn(viewModelScope)

    fun fetchDetailLocation(id: Int): MutableLiveData<LocationModel> {
        return locationRepository.fetchDetailLocation(id)
    }

    fun getAll() = locationRepository.getAll()    }


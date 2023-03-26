package com.example.rickandmortyapi.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.model.LocationModel
import com.example.rickandmortyapi.model.RickAndMortyResponce
import com.example.rickandmortyapi.repozitory.LocationRepozitory
import retrofit2.Call
import retrofit2.Response

class LocationViewModel : ViewModel() {

        private val locationRepository = LocationRepozitory()

        fun fetchLocation() = locationRepository.fetchLocation().cachedIn(viewModelScope)

        fun fetchDetailLocation(id: Int): MutableLiveData<LocationModel> {
            return locationRepository.fetchDetailLocation(id)
        }
    }


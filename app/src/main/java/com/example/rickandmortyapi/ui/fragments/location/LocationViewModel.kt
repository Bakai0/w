package com.example.rickandmortyapi.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.model.LocationModel
import com.example.rickandmortyapi.model.RickAndMortyResponce
import retrofit2.Call
import retrofit2.Response

class LocationViewModel : ViewModel() {
    fun fetchLocation(): MutableLiveData<RickAndMortyResponce<LocationModel>> {
        val data: MutableLiveData<RickAndMortyResponce<LocationModel>> = MutableLiveData()
        App.locationApiService?.fetchLocation()
            ?.enqueue(object : retrofit2.Callback<RickAndMortyResponce<LocationModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponce<LocationModel>>,
                    response: Response<RickAndMortyResponce<LocationModel>>,
                ) {
                    response.body()?.let {
                        data.value = it
                    }
                }
                override fun onFailure(
                    call: Call<RickAndMortyResponce<LocationModel>>,
                    t: Throwable,
                ) {
                    data.value = null
                }

            })
        return data
    }
}

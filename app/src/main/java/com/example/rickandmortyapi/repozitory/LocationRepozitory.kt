package com.example.rickandmortyapi.repozitory

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.model.LocationModel
import com.example.rickandmortyapi.repozitory.pagingsources.LocationPagingSources
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class LocationRepozitory {

    fun fetchLocation(): Flow<PagingData<LocationModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                LocationPagingSources(App.locationApiService!!)
            }).flow
    }

    fun fetchDetailLocation(id: Int): MutableLiveData<LocationModel> {
        val data: MutableLiveData<LocationModel> = MutableLiveData()
        App.locationApiService?.fetchDetailLocation(id)
            ?.enqueue(object : retrofit2.Callback<LocationModel> {
                override fun onResponse(
                    call: retrofit2.Call<LocationModel>,
                    response: Response<LocationModel>
                ) {
                    data.value = response.body()
                }
                override fun onFailure(
                    call: retrofit2.Call<LocationModel>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}
package com.example.rickandmortyapi.repozitory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.data.db.daos.LocationDao
import com.example.rickandmortyapi.data.network.apiservise.LocationApiService
import com.example.rickandmortyapi.model.CharacterModel
import com.example.rickandmortyapi.model.EpisodeModel
import com.example.rickandmortyapi.model.LocationModel
import com.example.rickandmortyapi.model.RickAndMortyResponce
import com.example.rickandmortyapi.repozitory.pagingsources.LocationPagingSources
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LocationRepozitory  @Inject constructor(
    private val locationApiService: LocationApiService,
    private val locationDao: LocationDao
) {
    fun fetchLocation(): MutableLiveData<RickAndMortyResponce<LocationModel>> {
        val data: MutableLiveData<RickAndMortyResponce<LocationModel>> = MutableLiveData()
        App.locationApiService?.fetchLocation()
            ?.enqueue(object : Callback<RickAndMortyResponce<LocationModel>> {

                override fun onResponse(
                    call: retrofit2.Call<RickAndMortyResponce<LocationModel>>,
                    response: Response<RickAndMortyResponce<LocationModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: retrofit2.Call<RickAndMortyResponce<LocationModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }

        fun fetchDetailLocation(id: Int): MutableLiveData<LocationModel> {
            val data: MutableLiveData<LocationModel> = MutableLiveData()
            App.locationApiService?.fetchDetailLocation(id)
                ?.enqueue(object : Callback<LocationModel> {

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

//        fun fetchLocation(): Flow<PagingData<LocationModel>> {
        //        return Pager(
//            config = PagingConfig(
//                pageSize = 10,
//                enablePlaceholders = false
//            ),
//            pagingSourceFactory = {
//                LocationPagingSources(App.locationApiService!!)
//            }).flow
//    }

        fun getAll(): LiveData<List<LocationModel>> {
            return locationDao.getAll()
        }
    }

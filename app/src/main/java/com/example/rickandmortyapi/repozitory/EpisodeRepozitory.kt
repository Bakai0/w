package com.example.rickandmortyapi.repozitory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.data.db.daos.EpisodeDao
import com.example.rickandmortyapi.data.network.apiservise.EpisodApiService
import com.example.rickandmortyapi.model.CharacterModel
import com.example.rickandmortyapi.model.EpisodeModel
import com.example.rickandmortyapi.model.RickAndMortyResponce
import com.example.rickandmortyapi.repozitory.pagingsources.EpisodePagingSources
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class EpisodeRepozitory @Inject constructor(
    private val episodeApiService: EpisodApiService,
    private val episodeDao: EpisodeDao
) {
    fun fetchEpisode(): MutableLiveData<RickAndMortyResponce<EpisodeModel>> {
        val data: MutableLiveData<RickAndMortyResponce<EpisodeModel>> = MutableLiveData()
        App.episodeApiService?.fetchEpisodes()
            ?.enqueue(object : Callback<RickAndMortyResponce<EpisodeModel>> {

                override fun onResponse(
                    call: Call<RickAndMortyResponce<EpisodeModel>>,
                    response: Response<RickAndMortyResponce<EpisodeModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponce<EpisodeModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }

    fun fetchDetailEpisode(id: Int): MutableLiveData<EpisodeModel> {
        val data: MutableLiveData<EpisodeModel> = MutableLiveData()
        App.episodeApiService?.fetchDetailEpisode(id)
            ?.enqueue(object : Callback<EpisodeModel> {

                override fun onResponse(
                    call: Call<EpisodeModel>,
                    response: Response<EpisodeModel>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(call: Call<EpisodeModel>, t: Throwable) {
                    data.value = null
                }
            })
        return data
    }

    fun getAll(): LiveData<List<EpisodeModel>> {
        return episodeDao.getAll()
    }
}

//    fun fetchEpisode(): Flow<PagingData<EpisodeModel>> {
//        return Pager(
//            config = PagingConfig(
//                pageSize = 10,
//                enablePlaceholders = false
//            ),
//            pagingSourceFactory = {
//                EpisodePagingSources(App.episodeApiService!!)
//            }).flow



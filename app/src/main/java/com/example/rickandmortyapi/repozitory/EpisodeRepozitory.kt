package com.example.rickandmortyapi.repozitory

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.model.EpisodeModel
import com.example.rickandmortyapi.repozitory.pagingsources.EpisodePagingSources
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeRepozitory{

    fun fetchEpisode(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                EpisodePagingSources(App.episodeApiService!!)
            }).flow
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

                override fun onFailure(
                    call: Call<EpisodeModel>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}
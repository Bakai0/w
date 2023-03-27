package com.example.rickandmortyapi.repozitory

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.model.CharacterModel
import com.example.rickandmortyapi.repozitory.pagingsources.CharacterPagingSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Callback
import retrofit2.Response

class CharacterRepozitory {

    fun fetchCharacter(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CharacterPagingSource(App.characterApiServices!!)
            }).flow
    }

    fun fetchDetailCharacter(id: Int): MutableLiveData<CharacterModel> {
        val data: MutableLiveData<CharacterModel> = MutableLiveData()
        App.characterApiServices?.fetchDetailCharacters(id)
            ?.enqueue(object : Callback<CharacterModel> {

                override fun onResponse(
                    call: retrofit2.Call<CharacterModel>,
                    response: Response<CharacterModel>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: retrofit2.Call<CharacterModel>,
                    t: Throwable) {
                    data.value = null
                }
            })
        return data
    }
}
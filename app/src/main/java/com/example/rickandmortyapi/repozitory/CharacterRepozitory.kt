package com.example.rickandmortyapi.repozitory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.data.db.daos.CharacterDao
import com.example.rickandmortyapi.data.network.apiservise.CharacterApiService
import com.example.rickandmortyapi.model.CharacterModel
import com.example.rickandmortyapi.model.RickAndMortyResponce
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CharacterRepozitory @Inject constructor(
    private val characterApiService: CharacterApiService,
    private val characterDao: CharacterDao
) {
     fun fetchCharacter(): MutableLiveData<RickAndMortyResponce<CharacterModel>> {
        val data: MutableLiveData<RickAndMortyResponce<CharacterModel>> = MutableLiveData()
        App.characterApiServices?.fetchCHaracters()
            ?.enqueue(object : Callback<RickAndMortyResponce<CharacterModel>> {

                override fun onResponse(
                    call: retrofit2.Call<RickAndMortyResponce<CharacterModel>>,
                    response: Response<RickAndMortyResponce<CharacterModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: retrofit2.Call<RickAndMortyResponce<CharacterModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }

//    fun fetchCharacter(): Flow<PagingData<CharacterModel>> {
//        return Pager(
//            config = PagingConfig(
//                pageSize = 10,
//                enablePlaceholders = false
//            ),
//            pagingSourceFactory = {
//                CharacterPagingSource(App.characterApiServices!!)
//            }).flow
//    }

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
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }

    fun getAll(): LiveData<List<CharacterModel>> {
        return characterDao.getAll()
    }
}
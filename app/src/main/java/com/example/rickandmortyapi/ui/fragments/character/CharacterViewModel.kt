package com.example.rickandmortyapi.ui.fragments.character

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.model.CharacterModel
import com.example.rickandmortyapi.model.RickAndMortyResponce
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class CharacterViewModel : ViewModel() {

    
    fun fetchCharacters(): MutableLiveData<RickAndMortyResponce<CharacterModel>>{
        val data : MutableLiveData<RickAndMortyResponce<CharacterModel>> = MutableLiveData()
        App.characterApiServices?.fetchCHaracters()?.enqueue (object : retrofit2.Callback<RickAndMortyResponce<CharacterModel>>{
            override fun onResponse(
                call: Call<RickAndMortyResponce<CharacterModel>>,
                response: Response<RickAndMortyResponce<CharacterModel>>
            ) {
                response.body()?.let {
                    data.value = it
                    Log.e("DATA", it.result.toString())
                }
            }

            override fun onFailure(call: Call<RickAndMortyResponce<CharacterModel>>, t: Throwable) {
                Log.e("ERROR", t.localizedMessage)
                data.value = null
            }
        })
        return  data
    }
}
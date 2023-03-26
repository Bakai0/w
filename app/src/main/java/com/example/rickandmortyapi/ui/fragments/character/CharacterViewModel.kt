package com.example.rickandmortyapi.ui.fragments.character

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.model.CharacterModel
import com.example.rickandmortyapi.model.RickAndMortyResponce
import com.example.rickandmortyapi.repozitory.CharacterRepozitory
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class CharacterViewModel : ViewModel() {

    private val characterRepository = CharacterRepozitory()

    fun fetchCharacter() = characterRepository.fetchCharacter().cachedIn(viewModelScope)

    fun fetchDetailCharacters(id: Int): MutableLiveData<CharacterModel> {
        return characterRepository.fetchDetailCharacter(id)
    }
}
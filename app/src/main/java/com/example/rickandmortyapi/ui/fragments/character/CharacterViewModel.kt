package com.example.rickandmortyapi.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapi.model.CharacterModel
import com.example.rickandmortyapi.repozitory.CharacterRepozitory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepozitory: CharacterRepozitory
) : ViewModel() {

    fun fetchCharacters() = characterRepozitory.fetchCharacter()
//        .cachedIn(viewModelScope)

    fun getAll() = characterRepozitory.getAll()
}

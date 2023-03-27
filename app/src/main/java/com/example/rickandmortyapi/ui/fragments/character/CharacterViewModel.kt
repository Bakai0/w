package com.example.rickandmortyapi.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortyapi.model.CharacterModel
import com.example.rickandmortyapi.repozitory.CharacterRepozitory

class CharacterViewModel : ViewModel() {

    private val characterRepository = CharacterRepozitory()

    fun fetchCharacter() = characterRepository.fetchCharacter().cachedIn(viewModelScope)

    fun fetchDetailCharacters(id: Int): MutableLiveData<CharacterModel> {
        return characterRepository.fetchDetailCharacter(id)
    }
}
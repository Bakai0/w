package com.example.rickandmortyapi.ui.fragments.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentCharacterBinding
import com.example.rickandmortyapi.repozitory.base.BaseFragment
import com.example.rickandmortyapi.ui.adapters.CharacterAdapter
import kotlinx.coroutines.launch

class CharacterFragment:  BaseFragment<FragmentCharacterBinding, CharacterViewModel>(R.layout.fragment_character) {

    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by activityViewModels()
    private var characterAdapter = CharacterAdapter(this::onItemClick)

    override fun initialize() {
        binding.characterRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    override fun setupObserve() {
        lifecycleScope.launch {
            viewModel.fetchCharacter().collect {
                characterAdapter.submitData(it)
            }
        }
    }

    private fun onItemClick(id: Int) {
        val action: NavDirections =
            CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment(id)
        findNavController().navigate(action)
    }
}
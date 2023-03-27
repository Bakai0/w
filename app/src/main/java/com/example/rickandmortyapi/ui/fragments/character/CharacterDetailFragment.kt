package com.example.rickandmortyapi.ui.fragments.character

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentCharacterDetailBinding
import com.example.rickandmortyapi.exeption.setImage
import com.example.rickandmortyapi.base.BaseFragment

class CharacterDetailFragment :
    BaseFragment<FragmentCharacterDetailBinding,
            CharacterViewModel>(R.layout.fragment_character_detail) {

    override val binding by viewBinding(FragmentCharacterDetailBinding::bind)
    override val viewModel: CharacterViewModel by activityViewModels()
    private val args by navArgs<CharacterDetailFragmentArgs>()

    override fun setupObserve() {
        viewModel.fetchDetailCharacters(args.id).observe(viewLifecycleOwner) {
            binding.tvCharacterDetailName.text = it.name
            binding.imgCharacterDetailPerson.setImage(it.image)
        }
    }
}
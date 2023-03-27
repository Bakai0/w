package com.example.rickandmortyapi.ui.fragments.character.detail

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentCharacterDetailBinding
import com.example.rickandmortyapi.exeption.setImage
import com.example.rickandmortyapi.base.BaseFragment
import com.example.rickandmortyapi.ui.fragments.character.CharacterDetailViewModel
import kotlinx.coroutines.launch

class CharacterDetailFragment :
    BaseFragment<FragmentCharacterDetailBinding,
            CharacterDetailViewModel>(R.layout.fragment_character_detail) {

    override val binding by viewBinding(FragmentCharacterDetailBinding::bind)
    override val viewModel: CharacterDetailViewModel by viewModels()
    private val args by navArgs<CharacterDetailFragmentArgs>()

    override fun setupObserve() {
        lifecycleScope.launch {
            viewModel.fetchDetailCharacter(args.id).observe(viewLifecycleOwner) {
                binding.tvCharacterDetailName.text = it.name

                binding.imgCharacterDetailPerson.setImage(it.image)
            }
        }
    }
}
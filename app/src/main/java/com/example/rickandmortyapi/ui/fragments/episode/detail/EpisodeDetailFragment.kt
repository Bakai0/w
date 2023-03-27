package com.example.rickandmortyapi.ui.fragments.episode.detail

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentEpisodeDetailBinding
import com.example.rickandmortyapi.base.BaseFragment
import kotlinx.coroutines.launch

class EpisodeDetailFragment :
    BaseFragment<FragmentEpisodeDetailBinding, EpisodeDetailViewModel>(R.layout.fragment_episode_detail) {

    override val binding by viewBinding(FragmentEpisodeDetailBinding::bind)
    override val viewModel: EpisodeDetailViewModel by viewModels()
    private val args by navArgs<EpisodeDetailFragmentArgs>()

    override fun setupObserve() {
        lifecycleScope.launch {
            viewModel.fetchDetailEpisode(args.id).observe(viewLifecycleOwner) {
                binding.tvEpisodeDetailName.text = it.name
                binding.tvEpisodeDetailAirData.text = it.air_date
            }
        }
    }
}

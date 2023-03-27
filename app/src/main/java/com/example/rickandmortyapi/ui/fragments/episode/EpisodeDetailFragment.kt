package com.example.rickandmortyapi.ui.fragments.episode

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentEpisodeDetailBinding
import com.example.rickandmortyapi.base.BaseFragment

class EpisodeDetailFragment :
    BaseFragment<FragmentEpisodeDetailBinding, EpisodeViewModel>(R.layout.fragment_episode_detail) {

    override val binding by viewBinding(FragmentEpisodeDetailBinding::bind)
    override val viewModel: EpisodeViewModel by activityViewModels()
    private val args by navArgs<EpisodeDetailFragmentArgs>()

    override fun setupObserve() {
        viewModel.fetchDetailEpisode(args.id).observe(viewLifecycleOwner) {
            binding.tvEpisodeDetailName.text = it.name
            binding.tvEpisodeDetailAirData.text = it.air_date
        }
    }
}

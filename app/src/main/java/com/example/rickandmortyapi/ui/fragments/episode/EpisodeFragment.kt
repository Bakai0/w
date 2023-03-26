package com.example.rickandmortyapi.ui.fragments.episode

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentEpisodeBinding
import com.example.rickandmortyapi.repozitory.base.BaseFragment
import com.example.rickandmortyapi.ui.adapters.EpisodeAdapter
import kotlinx.coroutines.launch

class EpisodeFragment :
    BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(R.layout.fragment_episode) {

    override val binding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeViewModel by activityViewModels()
    private var episodeAdapter = EpisodeAdapter(this::onItemClick)

    override fun initialize() {
        binding.episodeRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
        }
    }

    override fun setupObserve() {
        lifecycleScope.launch {
            viewModel.fetchEpisode().collect {
                episodeAdapter.submitData(it)
            }
        }
    }

    private fun onItemClick(id:Int) {
        val action: NavDirections =
            EpisodeFragmentDirections.actionEpisodeFragmentToEpisodeDetailFragment(id)
        findNavController().navigate(action)
    }
}
package com.example.rickandmortyapi.ui.fragments.location.detail

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentLocationDetailBinding
import com.example.rickandmortyapi.base.BaseFragment
import com.example.rickandmortyapi.ui.fragments.location.LocationViewModel

class LocationDetailFragment :
    BaseFragment<FragmentLocationDetailBinding, LocationDetailViewModel>(R.layout.fragment_location_detail) {

    override val binding by viewBinding(FragmentLocationDetailBinding::bind)
    override val viewModel: LocationDetailViewModel by viewModels()
    private val args by navArgs<LocationDetailFragmentArgs>()

    override fun setupObserve() {
        viewModel.fetchDetailLocation(args.id).observe(viewLifecycleOwner) {
            binding.tvLocationDetailName.text = it.name
            binding.tvLocationDetailCreated.text = it.created
        }
    }
}
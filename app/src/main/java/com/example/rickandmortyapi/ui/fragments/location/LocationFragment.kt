package com.example.rickandmortyapi.ui.fragments.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentLocationBinding
import com.example.rickandmortyapi.repozitory.base.BaseFragment
import com.example.rickandmortyapi.ui.adapters.LocationAdapter
import kotlinx.coroutines.launch

class LocationFragment  :
    BaseFragment<FragmentLocationBinding, LocationViewModel>(R.layout.fragment_location) {

    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by activityViewModels()
    private var locationAdapter = LocationAdapter(this::onItemClick)


    override fun initialize() {
        binding.recyclerLocation.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationAdapter
        }
    }

    override fun setupObserve() {
        lifecycleScope.launch {
            viewModel.fetchLocation().collect {
                locationAdapter.submitData(it)
            }
        }
    }

    private fun onItemClick(id:Int) {
        val action: NavDirections =
            LocationFragmentDirections.actionLocationFragmentToLocationDetailFragment(id)
        findNavController().navigate(action)
    }
}
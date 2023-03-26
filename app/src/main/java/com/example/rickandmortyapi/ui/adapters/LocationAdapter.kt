package com.example.rickandmortyapi.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.databinding.ItemCharacterBinding
import com.example.rickandmortyapi.databinding.ItemLocationBinding
import com.example.rickandmortyapi.model.CharacterModel
import com.example.rickandmortyapi.model.LocationModel

class LocationAdapter(val onItemClick: (id: Int) -> Unit) :
    PagingDataAdapter<LocationModel, LocationAdapter.LocationViewHolder>(diffUtil) {

    inner class LocationViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { loacation -> onItemClick(loacation.id) }
            }
        }
        fun onBind(locationModel: LocationModel) {
            binding.itemLocationCreated.text = locationModel.created
            binding.itemLocationName.text = locationModel.name
            binding.itemLocationType.text = locationModel.type
            binding.itemLocationDimension.text = locationModel.dimension

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            ItemLocationBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LocationAdapter.LocationViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<LocationModel>() {
            override fun areItemsTheSame(
                oldItem: LocationModel,
                newItem: LocationModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: LocationModel,
                newItem: LocationModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}

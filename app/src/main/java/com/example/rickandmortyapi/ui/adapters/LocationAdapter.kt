package com.example.rickandmortyapi.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.databinding.ItemCharacterBinding
import com.example.rickandmortyapi.databinding.ItemLocationBinding
import com.example.rickandmortyapi.model.CharacterModel
import com.example.rickandmortyapi.model.LocationModel

class LocationAdapter: RecyclerView.Adapter<LocationAdapter.ViewHolder>() {

    private var listLocation: List<LocationModel> = ArrayList()

    fun setList(list: List<LocationModel>) {
        this.listLocation = list
        notifyDataSetChanged()
    }

    class ViewHolder (private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(locationModel: LocationModel) {
            binding.itemLocationCreated.text = locationModel.created
            binding.itemLocationName.text = locationModel.name
            binding.itemLocationType.text = locationModel.type
            binding.itemLocationDimension.text = locationModel.dimension

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLocationBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listLocation[position])
    }

    override fun getItemCount(): Int = listLocation.size

    }

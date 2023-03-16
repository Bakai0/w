package com.example.rickandmortyapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.databinding.ItemCharacterBinding
import com.example.rickandmortyapi.model.CharacterModel

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
    private var list: List<CharacterModel> = ArrayList()

    fun setlist(list: List<CharacterModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(characterModel: CharacterModel) {
            binding.itemCharacterName.text = characterModel.name
            binding.itemCharacterGender.text = characterModel.gender
            binding.itemCharacterStatus.text = characterModel.status
            Glide.with(binding.itemCharacterImage.context).load(characterModel.image)
                .into(binding.itemCharacterImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}
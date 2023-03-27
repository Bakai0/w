package com.example.rickandmortyapi.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class EpisodeModel(

    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("air_date")
    val air_date: String,

    @SerializedName("created")
    val created: String,

    @SerializedName("episode")
    val episode: String
)

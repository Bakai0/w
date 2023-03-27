package com.example.rickandmortyapi.model

import androidx.annotation.Dimension
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class LocationModel(

    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("dimension")
    val dimension: String,

    @SerializedName("created")
    val created: String

)

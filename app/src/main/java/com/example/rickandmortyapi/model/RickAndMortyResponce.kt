package com.example.rickandmortyapi.model

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponce<T>(

    @SerializedName("info")
    val info: Info,

    @SerializedName("results")
    val result: ArrayList<T>

)

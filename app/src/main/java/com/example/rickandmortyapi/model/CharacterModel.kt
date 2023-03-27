package com.example.rickandmortyapi.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class CharacterModel (

  @SerializedName("id")
  @PrimaryKey(autoGenerate = true)
  val id: Int,

  @SerializedName("name")
  val name: String,

  @SerializedName("image")
  val image:String,

  @SerializedName("status")
  val status: String,

  @SerializedName("gender")
  val gender: String,

  @SerializedName("origin")
  val origin: Any
  )
package com.example.rxworkshop.data.model

import com.google.gson.annotations.SerializedName

data class SimpleCharacterApiModel(
    @SerializedName("uid")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
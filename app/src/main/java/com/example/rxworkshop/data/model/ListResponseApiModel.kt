package com.example.rxworkshop.data.model

import com.google.gson.annotations.SerializedName

data class ListResponseApiModel(
    @SerializedName("message")
    val message: String,
    @SerializedName("results")
    val results: List<SimpleCharacterApiModel>
)
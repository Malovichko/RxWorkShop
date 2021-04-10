package com.example.rxworkshop.data.model

import com.google.gson.annotations.SerializedName

data class ItemResponseApiModel(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: SimplePropertiesApiModel
)

package com.example.rxworkshop.data.model

import com.google.gson.annotations.SerializedName

data class PropertiesApiModel(
//    @SerializedName("height")
//    val height: Int,
//    @SerializedName("mass")
//    val mass: Int,
//    @SerializedName("hair_color")
//    val hair_color: String,
//    @SerializedName("skin_color")
//    val skin_color: String,
//    @SerializedName("eye_color")
//    val eye_color: String,
    @SerializedName("birth_year")
    val birth_year: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    val name: String
)
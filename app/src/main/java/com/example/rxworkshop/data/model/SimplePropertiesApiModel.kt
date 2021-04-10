package com.example.rxworkshop.data.model

import com.google.gson.annotations.SerializedName

data class SimplePropertiesApiModel (
    @SerializedName("properties")
    val properties: PropertiesApiModel
)
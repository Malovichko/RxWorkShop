package com.example.rxworkshop

import com.example.rxworkshop.data.StarWarsApiService
import retrofit2.Retrofit

object NetworkHolder {
    var retrofitservice: StarWarsApiService? = null
}
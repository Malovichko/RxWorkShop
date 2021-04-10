package com.example.rxworkshop

import android.app.Application
import com.example.rxworkshop.data.StarWarsApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NewMyApplication : Application() {
    //    lateinit var retrofitservice: StarWarsApiService
    override fun onCreate() {
        super.onCreate()
        initRetrofitService()
    }

    private fun initRetrofitService() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.swapi.tech/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        NetworkHolder.retrofitservice = retrofit.create(StarWarsApiService::class.java)
    }
}
package com.example.rxworkshop

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import com.example.rxworkshop.data.NetworkHolder
import com.example.rxworkshop.data.StarWarsApiService
import com.example.rxworkshop.data.database.CharacterDatabase
import com.example.rxworkshop.data.database.DatabaseHolder
import com.example.rxworkshop.data.database.dao.CharacterDao
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NewMyApplication : Application() {
    //    lateinit var retrofitservice: StarWarsApiService
    override fun onCreate() {
        super.onCreate()
        initRetrofitService()
        initDataBase()
    }

    private fun initRetrofitService() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.swapi.tech/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        NetworkHolder.retrofitservice = retrofit.create(StarWarsApiService::class.java)
    }

    private fun initDataBase() {
        val db = Room.databaseBuilder(this, CharacterDatabase::class.java, "database").build()
        DatabaseHolder.database = db
    }


}
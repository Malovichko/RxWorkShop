package com.example.rxworkshop.data

import com.example.rxworkshop.data.model.ItemResponseApiModel
import com.example.rxworkshop.data.model.ListResponseApiModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsApiService {
    @GET("people")
    fun getCharacter(): Single<ListResponseApiModel>

    @GET("people/{characterId}")
    fun getCharacterInfo(@Path("characterId") characterId: Int) : Single<ItemResponseApiModel>
}

//прокидывать retrofit переопр класс application -> метод получения retrofitservice -> в активити


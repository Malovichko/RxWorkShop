package com.example.rxworkshop.domain.usecase

import com.example.rxworkshop.data.database.DatabaseHolder
import com.example.rxworkshop.data.database.entity.CharacterEntity
import com.example.rxworkshop.domain.mapper.CharacterMapper
import com.example.rxworkshop.domain.model.DataModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class InsertCharacterIntoDatabase {
    fun execute(characters: List<DataModel>) = DatabaseHolder
        .database!!
        .characterDao()?.insertAll(characters.map { CharacterMapper.mapToDB(it) }.toList())
        ?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())

}
package com.example.rxworkshop.domain.usecase

import android.provider.ContactsContract
import com.example.rxworkshop.data.database.DatabaseHolder
import com.example.rxworkshop.data.database.entity.CharacterEntity
import com.example.rxworkshop.domain.mapper.CharacterMapper
import com.example.rxworkshop.domain.model.DataModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GetCharacterFromDatabase {

    fun execute(): Single<List<DataModel>> = DatabaseHolder
        .database!!
        .characterDao()!!.getAll().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map { it.map { CharacterMapper.mapDB(it) }.toList() }

}
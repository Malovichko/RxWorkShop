package com.example.rxworkshop.domain.usecase

import com.example.rxworkshop.data.database.DatabaseHolder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers

class ClearCharacterList {
    fun execute(): Completable = DatabaseHolder
        .database!!
        .characterDao()
        .clearAll()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}
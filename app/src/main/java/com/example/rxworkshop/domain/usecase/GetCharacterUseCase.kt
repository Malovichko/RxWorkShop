package com.example.rxworkshop.domain.usecase

import com.example.rxworkshop.data.NetworkHolder
import com.example.rxworkshop.domain.mapper.CharacterMapper
import com.example.rxworkshop.domain.model.DataModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GetCharacterUseCase {
    fun execute(): Single<List<DataModel>> = NetworkHolder.retrofitservice!!.getCharacter()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map {
            return@map it.results.map { CharacterMapper.mapAPI(it) }.toList()
        }
}
package com.example.rxworkshop.listScreen.view

import android.util.Log
import android.widget.Toast
import com.example.rxworkshop.data.NetworkHolder
import com.example.rxworkshop.domain.model.DataModel
import com.example.rxworkshop.domain.usecase.ClearCharacterList
import com.example.rxworkshop.domain.usecase.GetCharacterFromDatabase
import com.example.rxworkshop.domain.usecase.GetCharacterUseCase
import com.example.rxworkshop.domain.usecase.InsertCharacterIntoDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class CharacterListPresenter constructor(private val view: CharacterListView) {

    private val getCharactersUseCase = GetCharacterUseCase()
    private val insertCharacterIntoDatabase = InsertCharacterIntoDatabase()
    private val getCharacterFromDatabase = GetCharacterFromDatabase()
    private val clearCharacterList = ClearCharacterList()

    fun insertCharacterDB(characters: List<DataModel>) {
        insertCharacterIntoDatabase.execute(characters)?.subscribe(
            {
                Log.i("Log", "Запись в базу данных")
            },
            {
                it.printStackTrace()
            }
        )
    }

    fun clearCharacterList() {
        clearCharacterList.execute()
            .subscribe({ Log.i("Log", "Отчистка спика на экране") }, { it.printStackTrace() })
    }


    fun getListFromDB() {
        getCharacterFromDatabase.execute().subscribe({
            view.setUpRecyclerList(it)
            Log.i("Log", "Получение элементов из базы данных")
        }, { it.printStackTrace() })
    }


    fun onViewCreated() {
        getCharactersUseCase.execute()
            .subscribe(
                {
//                    rewriteCharactersTable(it)
//                    clearCharacterList()
                    insertCharacterDB(it)

                    view.setUpRecyclerList(it)
                },
                {
                    it.printStackTrace()
                }
            )
    }

    fun loadCharacter() {
        view.setProgress(true)
        NetworkHolder.retrofitservice!!.getCharacter().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.results.map { DataModel(it.id, it.name) }.toList() }.subscribe({
                view.setUpRecyclerList(it)
//                insertCharacterDB(it)
                view.setProgress(false)
            }, {
                it.printStackTrace()
                view.setProgress(false)
            })
    }
}

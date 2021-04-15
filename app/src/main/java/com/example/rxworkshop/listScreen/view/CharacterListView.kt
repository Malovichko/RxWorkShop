package com.example.rxworkshop.listScreen.view

import com.example.rxworkshop.domain.model.DataModel

interface CharacterListView {
    fun setUpRecyclerList(list: List<DataModel>)
    fun setProgress(isVisible: Boolean)
}
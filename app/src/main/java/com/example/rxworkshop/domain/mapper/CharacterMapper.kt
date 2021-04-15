package com.example.rxworkshop.domain.mapper

import com.example.rxworkshop.data.database.entity.CharacterEntity
import com.example.rxworkshop.data.model.SimpleCharacterApiModel
import com.example.rxworkshop.domain.model.DataModel

object CharacterMapper {
    fun mapToDB(characterMap: DataModel) = CharacterEntity(
        characterMap.ID,
        characterMap.name
    )

    fun mapAPI(characterMap: SimpleCharacterApiModel) = DataModel(
        characterMap.id,
        characterMap.name
    )
    fun mapDB(characterMap: CharacterEntity) = DataModel(
        characterMap.id,
        characterMap.name
    )
}
package com.example.rxworkshop.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rxworkshop.data.database.dao.CharacterDao
import com.example.rxworkshop.data.database.entity.CharacterEntity


@Database(entities = [CharacterEntity::class], version = 1)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}
package com.example.rxworkshop.data.database.dao

import androidx.room.*
import com.example.rxworkshop.data.database.entity.CharacterEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single


@Dao
interface CharacterDao {
//    @get:Query("SELECT * FROM CharacterEntity")
//    val all: List<CharacterEntity>

    @Query("SELECT * FROM CharacterEntity WHERE id = :id")
    fun getById(id: Int): Single<CharacterEntity>

    @Query("SELECT * FROM CharacterEntity")
    fun getAll(): Single<List<CharacterEntity>>

    @Query("DELETE FROM CharacterEntity")
    fun clearAll(): Completable

    @Insert
    fun insert(character: CharacterEntity)

    @Insert
    fun insertAll(characters: List<CharacterEntity>): Completable

    @Update
    fun update(character: CharacterEntity)

    @Delete
    fun delete(character: CharacterEntity)
}
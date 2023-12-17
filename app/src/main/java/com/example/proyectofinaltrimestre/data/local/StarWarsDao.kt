package com.example.proyectofinaltrimestre.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StarWarsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createPokemon(listPokemon:List<StarWarsEntity>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createStarWars(swEntity: kotlin.collections.List<com.example.proyectofinaltrimestre.data.local.StarWarsEntity>)
    @Query("SELECT * FROM sw_people")
    fun getAllCharacters(): Flow<List<StarWarsEntity>>
}
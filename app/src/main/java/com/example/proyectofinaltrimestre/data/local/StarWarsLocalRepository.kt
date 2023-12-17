package com.example.proyectofinaltrimestre.data.local

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StarWarsLocalRepository @Inject constructor(private val starWarsDao: StarWarsDao) {
    val allCharacters:Flow<List<StarWarsEntity>> = starWarsDao.getAllCharacters()

    @WorkerThread
    suspend fun insert(listStarWarsEntity: List<StarWarsEntity>) =
        starWarsDao.createStarWars(listStarWarsEntity)
}
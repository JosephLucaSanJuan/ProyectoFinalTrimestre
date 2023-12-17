package com.example.proyectofinaltrimestre.data.repository

import com.example.proyectofinaltrimestre.data.local.StarWarsLocalRepository
import com.example.proyectofinaltrimestre.data.local.asListStarWars
import com.example.proyectofinaltrimestre.data.network.StarWarsNetworkRespository
import com.example.proyectofinaltrimestre.data.network.asEntityModelList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StarWarsRepository @Inject constructor(
    private val localRepository: StarWarsLocalRepository,
    private val networkRespository: StarWarsNetworkRespository
){
    val allCharacters:Flow<List<StarWars>>
        get() {
            return localRepository.allCharacters.map {
                listStarWarsEntity -> listStarWarsEntity.asListStarWars()
            }
        }
    suspend fun refreshList() = withContext(Dispatchers.IO) {
        val starWarsApiModelList = networkRespository.getAll()
        localRepository.insert(starWarsApiModelList.asEntityModelList())
    }
}
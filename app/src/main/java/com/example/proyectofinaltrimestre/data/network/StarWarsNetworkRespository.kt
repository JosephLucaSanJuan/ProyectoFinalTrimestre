package com.example.proyectofinaltrimestre.data.network

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StarWarsNetworkRespository @Inject constructor(private val service: StarWarsService){
    suspend fun getAll():List<StarWarsApiModel>{
        val simpleList = service.api.getAll()
        return simpleList.results.map {
            starWarsListItemResponse ->
                service.api.getDetail(starWarsListItemResponse.name).asApiModel()
        }
    }
}
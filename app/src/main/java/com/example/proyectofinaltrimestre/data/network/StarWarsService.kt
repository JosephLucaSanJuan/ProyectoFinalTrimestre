package com.example.proyectofinaltrimestre.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject
import javax.inject.Singleton

interface StarWarsApi {
    @GET("character")
    suspend fun getAll():StarWarsListResponse
    @GET("")
    suspend fun getDetail(@Path("name") name:String):StarWarsDetailResponse
}

@Singleton
class StarWarsService @Inject constructor() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://swapi.dev/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api:StarWarsApi = retrofit.create(StarWarsApi::class.java)
}
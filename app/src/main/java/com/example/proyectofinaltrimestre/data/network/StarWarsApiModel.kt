package com.example.proyectofinaltrimestre.data.network

import com.example.proyectofinaltrimestre.data.local.StarWarsEntity
import com.google.gson.annotations.SerializedName

data class StarWarsApiModel(
    val name:String,
    val id:Int,
    val planet:String,
    //val species:String,
    //val faction:String,
    val frontImage:String
)

fun List<StarWarsApiModel>.asEntityModelList():List<StarWarsEntity> {
    return this.map {
        StarWarsEntity(
            it.name,
            it.id,
            //it.species,
            it.planet,
            //it.faction,
            it.frontImage
        )
    }
}

data class StarWarsDetailResponse(
    val name: String,
    val id:Int,
    //val species: String,
    val planet: String,
    //val picture: StarWarsImageProjector
    val frontImage: String
) {
    fun asApiModel():StarWarsApiModel{
        return StarWarsApiModel(
            name,
            id,
            //species,
            planet,
            frontImage
        )
    }
}

/*data class StarWarsImageProjector(
    @SerializedName("front_image")
)*/

data class StarWarsListResponse(
    val results: List<StarWarsListItemResponse>
)

data class StarWarsListItemResponse(
    val name:String
)
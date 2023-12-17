package com.example.proyectofinaltrimestre.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.proyectofinaltrimestre.data.repository.StarWars

@Entity(tableName = "sw_people")
data class StarWarsEntity (
    @PrimaryKey
    val name:String,
    val id:Int?,
    //val species:String,
    val planet:String,
    //val faction:String,
    val frontImage:String?
)

fun List<StarWarsEntity>.asListStarWars():List<StarWars> {
    return this.map {
        StarWars(it.name,it.planet,it.frontImage)
    }
}
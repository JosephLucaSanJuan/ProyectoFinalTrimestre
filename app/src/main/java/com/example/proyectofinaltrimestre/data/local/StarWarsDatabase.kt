package com.example.proyectofinaltrimestre.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StarWarsEntity::class], version = 1)
abstract class StarWarsDatabase():RoomDatabase() {
    abstract fun starWarsDao():StarWarsDao

    companion object{
        @Volatile
        private var _INSTANCE:StarWarsDatabase? = null

        fun getInstance(context: Context):StarWarsDatabase {
            return _INSTANCE ?: synchronized(this) {
                _INSTANCE ?: buildDatabase(context).also {
                    database -> _INSTANCE = database
                }
            }
        }

        private fun buildDatabase(context: Context):StarWarsDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                StarWarsDatabase::class.java,
                "star_wars_db"
            ).build()
        }
    }
}
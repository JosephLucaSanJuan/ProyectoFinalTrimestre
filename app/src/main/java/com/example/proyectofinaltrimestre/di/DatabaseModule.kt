package com.example.proyectofinaltrimestre.di

import android.content.Context
import com.example.proyectofinaltrimestre.data.local.StarWarsDao
import com.example.proyectofinaltrimestre.data.local.StarWarsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): StarWarsDatabase {
        return StarWarsDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideStarWarsDao(database: StarWarsDatabase):StarWarsDao{
        return database.starWarsDao()
    }
}
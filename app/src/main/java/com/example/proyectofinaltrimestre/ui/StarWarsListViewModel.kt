package com.example.proyectofinaltrimestre.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinaltrimestre.data.repository.StarWars
import com.example.proyectofinaltrimestre.data.repository.StarWarsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class StarWarsListViewModel @Inject constructor(private val repository: StarWarsRepository):ViewModel(){
    private val _characterList:MutableStateFlow<List<StarWars>>
        = MutableStateFlow(listOf())
    val starWarsList:StateFlow<List<StarWars>>
        get() = _characterList.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                repository.refreshList()
            }
            catch (e:IOException){}
        }
        viewModelScope.launch {
            repository.allCharacters.collect {
                _characterList.value = it
            }
        }
    }
}
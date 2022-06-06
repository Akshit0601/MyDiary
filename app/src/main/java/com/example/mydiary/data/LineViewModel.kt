package com.example.mydiary.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LineViewModel(application: Application):AndroidViewModel(application) {
    val readAllData: LiveData<List<Line>>
    private val repository: LineRepository

    init{
        val lineDao= LineDatabase.getDatabase(application)?.lineDao()
        repository= lineDao?.let { LineRepository(it) }!!
        readAllData = repository.readAllData

    }

    fun addLine(line:Line){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addLine(line)
        }
    }

}
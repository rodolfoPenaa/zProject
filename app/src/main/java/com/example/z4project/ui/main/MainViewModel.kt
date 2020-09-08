package com.example.z4project.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.z4project.model.Ilustration
import com.example.z4project.model.Repository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val fromRepository= Repository(application)
    private val loadedList: LiveData<MutableList<Ilustration>> =fromRepository.loadToViewModel()

    fun refreshDATAserver(){
        return fromRepository.fetchDATAs()
    }
    fun getDATAr00m(): LiveData<MutableList<Ilustration>>{
        return loadedList
    }

}
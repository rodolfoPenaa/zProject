package com.example.z4project.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.z4project.model.Ilustration
import com.example.z4project.model.Repository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val fromRepository= Repository(application)
    private val loadedList: LiveData<MutableList<Ilustration>> = fromRepository.loadToViewModel()

    fun exposeLiveDataFromServer(): MutableLiveData<List<Ilustration>> {
        return fromRepository.liveFromSERVER
    }

    fun refreshDATAserver(){
        return fromRepository.fetchDATAs()
    }

    fun getDATAr00m(): LiveData<MutableList<Ilustration>>{
        return loadedList
    }

}
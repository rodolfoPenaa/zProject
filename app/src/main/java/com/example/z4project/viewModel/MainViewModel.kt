package com.example.z4project.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.z4project.model.Ilustration
import com.example.z4project.model.IlustrationFavEntity
import com.example.z4project.model.Repository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val fromRepository=Repository(application)
    private val loadedList: LiveData<MutableList<Ilustration>> = fromRepository.loadToViewModel()
    private val loadedFavList: LiveData<List<IlustrationFavEntity>> = fromRepository.fetchFavDDBB()

    fun saveFavorite(viewMFav:IlustrationFavEntity){
        fromRepository.putFavDDBB(viewMFav)
    }

    fun changeToFav(catchedIlustration:Ilustration){
        return fromRepository.cleanFromAll(catchedIlustration)
    }

    fun updateToFav(catchedUpdateIlustration:Ilustration){
        return fromRepository.updateFromAll(catchedUpdateIlustration)
    }

    fun exposeFromFavDDBB(): LiveData<List<IlustrationFavEntity>> {
        return loadedFavList
    }

    fun refreshDATAserver(){
        return fromRepository.fetchDATAs()
    }

    fun getDATAr00m(): LiveData<MutableList<Ilustration>>{
        return loadedList
    }


}
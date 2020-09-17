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

    fun removeFromFav(catchedFavIlu:IlustrationFavEntity){
        return fromRepository.cleanFromFav(catchedFavIlu)
    }

    fun saveFavorite(viewMFav:IlustrationFavEntity){
        fromRepository.putFavDDBB(viewMFav)
    }

    fun updateToFav(catchedUpdateIlustration:Ilustration){
        return fromRepository.updateFromAll(catchedUpdateIlustration)
    }

    fun updateFromFav(catchedUpdateIlustration:Ilustration){
        return fromRepository.putAddbb(catchedUpdateIlustration)
    }

    fun undertacker(cancelUpdate:Ilustration){
        return fromRepository.cleanFromAll(cancelUpdate)
    }

    fun getDATAr00m(): LiveData<MutableList<Ilustration>>{
        return loadedList
    }

    fun exposeFromFavDDBB(): LiveData<List<IlustrationFavEntity>> {
        return loadedFavList
    }

    fun refreshDATAserver(){
        return fromRepository.fetchDATAs()
    }




}
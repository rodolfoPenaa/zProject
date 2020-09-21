package com.example.z4project.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.z4project.model.Ilustration
import com.example.z4project.model.IlustrationFavEntity
import com.example.z4project.model.Repository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val fromRepository=Repository(application)
    private val loadedList: LiveData<MutableList<Ilustration>> = fromRepository.loadToView()
    private val loadedFavList: LiveData<List<IlustrationFavEntity>> = fromRepository.fetchFavDDBB()

    fun updateToFav(catchedUpdateIlustration:Ilustration){
        return fromRepository.updateFromAll(catchedUpdateIlustration)
    }

    fun saveFavorite(viewMFav:IlustrationFavEntity){
        return fromRepository.putFavDDBB(viewMFav)
    }

    fun updateFromFav(catchedUpdateIlustration:Ilustration){
        return fromRepository.putAddbb(catchedUpdateIlustration)
    }

    fun removeFromFav(catchedFavIlu:IlustrationFavEntity){
        return fromRepository.cleanFromFav(catchedFavIlu)
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
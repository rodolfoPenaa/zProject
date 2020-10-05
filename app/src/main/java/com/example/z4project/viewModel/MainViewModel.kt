package com.example.z4project.viewModel

import android.app.Application
import android.util.Log
import retrofit2.HttpException
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.z4project.model.Ilustration
import com.example.z4project.model.IlustrationFavEntity
import com.example.z4project.model.Repository
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val fromRepository=Repository(application)
    private val loadedList: LiveData<MutableList<Ilustration>> = fromRepository.loadToView()
    private val loadedFavList: LiveData<List<IlustrationFavEntity>> = fromRepository.fetchFavDDBB()

    val word1 = MutableLiveData<String>()

    fun fetchPhrase() = viewModelScope.launch {
        try {
            fromRepository.suspendWord()
        }catch (e:HttpException){
         word1.postValue("404")
            Log.e("APIfail", e.toString())
        }catch (e:Exception) {
            word1.postValue("Critical Error")
            Log.e("No http", e.toString())
        }
    }

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
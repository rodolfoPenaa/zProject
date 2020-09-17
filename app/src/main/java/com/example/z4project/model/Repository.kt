package com.example.z4project.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.z4project.model.db.R00mDataBase
import com.example.z4project.model.api.Rclient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

data class Repository(val context: Context) {
    private val instanceIluR00m: R00mDataBase = R00mDataBase.getDDBB(context)

    //private val instanceFavIluR00m: R00mDataBase = R00mDataBase.getFavDDBB(context)
    private val loadList: LiveData<MutableList<Ilustration>> = instanceIluR00m.dataBASE().getIlustrationsDDBB()
    private var loadFavList: LiveData<List<IlustrationFavEntity>> = instanceIluR00m.dataBASE().getFavIlustrations()

    fun putAddbb(ilustrationReturn: Ilustration){
        CoroutineScope(Dispatchers.IO).launch {
            ilustrationReturn.let {
                instanceIluR00m.dataBASE().insertAilustration(it)
            }
        }
    }

    fun putFavDDBB(favIlustration: IlustrationFavEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            favIlustration.let {
                instanceIluR00m.dataBASE().insertSelectioned(it)
            }
        }
    }

    fun fetchFavDDBB(): LiveData<List<IlustrationFavEntity>> {
        return loadFavList
    }

    fun cleanFromFav(deleteFavIlu:IlustrationFavEntity){
        CoroutineScope(Dispatchers.IO).launch {
            deleteFavIlu.let {
                instanceIluR00m.dataBASE().deleteFromFav(it)
            }
        }
    }

    fun fetchDATAs() {
        Rclient.retrofitIg().getAllIlustration().enqueue(object : Callback<List<Ilustration>> {
            override fun onResponse(
                call: Call<List<Ilustration>>,
                response: Response<List<Ilustration>>
            ) {
                Log.d("apiresponse", response.body().toString())
                CoroutineScope(Dispatchers.IO).launch {          // To DDBB from call of API//
                    response.body()?.let {
                        instanceIluR00m.dataBASE().insertIlustrations(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<Ilustration>>, t: Throwable) {
                //Toast.makeText(, "Network error: $t", Toast.LENGTH_LONG).show()

                Log.e("API", "ERROR $t")
            }
        })
    }

    fun loadToViewModel(): LiveData<MutableList<Ilustration>> {
        return loadList
    }

    fun updateFromAll(updatedIlustration: Ilustration){
        instanceIluR00m.dataBASE().updateAllDDBB(updatedIlustration)
    }

    fun cleanFromAll(deleteIlustration: Ilustration){
        CoroutineScope(Dispatchers.IO).launch {
            deleteIlustration.let {
                instanceIluR00m.dataBASE().deleteFromall(deleteIlustration)
            }
        }

    }
}

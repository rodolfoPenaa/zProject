package com.example.z4project.model

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import androidx.lifecycle.LiveData
import com.example.z4project.model.db.R00mDataBase
import com.example.z4project.model.api.Rclient
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

data class Repository(val context: Context) {
    private val instanceIluR00m: R00mDataBase = R00mDataBase.getDDBB(context)
    private val loadList: LiveData<MutableList<Ilustration>> = instanceIluR00m.dataBASE().getIlustrationsDDBB()
    private val loadFavList: LiveData<List<IlustrationFavEntity>> = instanceIluR00m.dataBASE().getFavIlustrations()

    fun fetchDATAs() {
        Rclient.retrofitIlu().getAllIlustration().enqueue(object : Callback<List<Ilustration>> {
            override fun onResponse(
                call: Call<List<Ilustration>>,
                response: Response<List<Ilustration>>
            ) { CoroutineScope(Dispatchers.IO).launch {
                    response.body()?.let {
                        instanceIluR00m.dataBASE().insertIlustrations(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<Ilustration>>, t: Throwable) {
                Toast.makeText(context.applicationContext, t.toString()+"Network Error",Toast.LENGTH_LONG).show()
            }
        })
    }

    fun loadToView(): LiveData<MutableList<Ilustration>> {
        return loadList
    }

    fun updateFromAll(updatedIlustration:Ilustration){
        CoroutineScope(Dispatchers.IO).launch {
            instanceIluR00m.dataBASE().updateAllDDBB(updatedIlustration)
        }
    }

    fun cleanFromAll(deleteIlustration: Ilustration){
        CoroutineScope(Dispatchers.IO).launch {
            deleteIlustration.let {
                instanceIluR00m.dataBASE().deleteFromall(deleteIlustration)
            }
        }
    }

    fun putFavDDBB(favIlustration:IlustrationFavEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            favIlustration.let {
                instanceIluR00m.dataBASE().insertSelectioned(it)
            }
        }
    }

    fun fetchFavDDBB(): LiveData<List<IlustrationFavEntity>> {
        return loadFavList
    }

    fun putAddbb(ilustrationReturn:Ilustration){
        CoroutineScope(Dispatchers.IO).launch {
            ilustrationReturn.let {
                instanceIluR00m.dataBASE().insertAilustration(it)
            }
        }
    }

    fun cleanFromFav(deleteFavIlu:IlustrationFavEntity){
        CoroutineScope(Dispatchers.IO).launch {
            deleteFavIlu.let {
                instanceIluR00m.dataBASE().deleteFromFav(it)
            }
        }
    }

}

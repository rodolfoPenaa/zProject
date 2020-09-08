package com.example.z4project.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.z4project.db.R00mDataBase
import com.example.z4project.model.api.Rclient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

data class Repository(val context: Context) {
    private val instanceIluR00m: R00mDataBase = R00mDataBase.getDDBB(context)
    private val loadList: LiveData<MutableList<Ilustration>> = instanceIluR00m.dataBASE().getIlustrationsDDBB()

    fun fetchDATAs(){
        Rclient.retrofitInstance().getAllIlustration().enqueue(object : Callback<List<Ilustration>> {
            override fun onResponse(
                call: Call<List<Ilustration>>,
                response: Response<List<Ilustration>>
            ) {
                   Log.d("apiresponse", response.body().toString())
                CoroutineScope(Dispatchers.IO).launch {          // To DDBB from call of API//
                    response.body()?.let { instanceIluR00m.dataBASE().insertIlustrations(it)
                    }
                }
            }
            override fun onFailure(call: Call<List<Ilustration>>, t: Throwable) {
                //Toast.makeText(, "Network error: $t", Toast.LENGTH_LONG).show()

                Log.e("API", "ERROR $t")
            }
        })
    }

   fun loadToViewModel():LiveData<MutableList<Ilustration>> {
        return loadList
        }

}
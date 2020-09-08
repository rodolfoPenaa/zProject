package com.example.z4project.model.api

import androidx.lifecycle.LiveData
import com.example.z4project.model.Ilustration
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiEndP {
    @GET("estallido.json")
    fun getAllIlustration(): Call<List<Ilustration>>

    @GET("estallido.json")
   suspend fun getFromEnquee(): Response<List<Ilustration>>
}
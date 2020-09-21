package com.example.z4project.model.api

import com.example.z4project.model.Ilustration
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndP {

    @GET("estallido.json")
    fun getAllIlustration(): Call<List<Ilustration>>
}
package com.example.z4project.model.api

import com.example.z4project.model.Fhoto
import com.example.z4project.model.Ilustration
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiEndP {

    @GET("estallido.json")
    fun getAllIlustration(): Call<List<Ilustration>>

    @GET(value = "400/")
    fun getPhoto(): Call<Fhoto>

}
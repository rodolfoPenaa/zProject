package com.example.z4project.model

import retrofit2.Call
import retrofit2.http.GET

interface ApiEndP {
    @GET("estallido.json")
    fun getAllIlustration(): Call<List<Ilustration>>
}
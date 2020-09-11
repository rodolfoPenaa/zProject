package com.example.z4project.model.api

import com.example.z4project.model.Fhoto
import com.example.z4project.model.Ilustration
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiEndP {
    //Only Json consume
    @GET("estallido.json")
    fun getAllIlustration(): Call<List<Ilustration>>

    @GET("estallido.json")
   suspend fun getFromEnquee(): Response<List<Ilustration>>

    //Flickr consume
    @GET(value = "oauth/authorize")
    fun getoServer(): Call<List<Fhoto>>

    @GET("group/{id}/")  // debe corresponder con lo de abajo
    fun groupList(@Path("id") groupId: Int,  // debe corresponder con lo de arriba
                  @Query("funcionkey") mykey: String?): Call<List<Ilustration?>?>?

}
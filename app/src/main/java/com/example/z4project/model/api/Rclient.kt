package com.example.z4project.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Rclient() {

    companion object{
        private const val URL_FLCKR = "https://www.flickr.com/services/"
        private const val BASE_Ig = "https://corvalan.dev/evade/"

        fun retrofitIg(): ApiEndP{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_Ig)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiEndP::class.java)
        }

        fun retrofitFLICKR():ApiEndP{
            val retrofit = Retrofit.Builder()
                .baseUrl(URL_FLCKR)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiEndP::class.java)
        }

    }
}
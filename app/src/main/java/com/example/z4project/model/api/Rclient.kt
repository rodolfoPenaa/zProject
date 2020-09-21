package com.example.z4project.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Rclient() {

    companion object{
        private const val BASE_IG = "https://corvalan.dev/evade/"

        fun retrofitIlu(): ApiEndP{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_IG)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiEndP::class.java)
        }
    }
}
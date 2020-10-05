package com.example.z4project.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Rclient() {

    companion object{
        private const val BASE_IG = "https://corvalan.dev/evade/"
        private const val WELCOMEBASE = "https://www.affirmations.dev/"

        fun retrofitIlu(): ApiEndP{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_IG)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiEndP::class.java)
        }

        fun retroPhrase():ApiEndP{
            val retrofitSUSPEND = Retrofit.Builder()
                .baseUrl(WELCOMEBASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofitSUSPEND.create(ApiEndP::class.java)
    }
}
}
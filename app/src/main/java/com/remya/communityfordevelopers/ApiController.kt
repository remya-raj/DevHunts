package com.remya.communityfordevelopers

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiController {
    init {
        retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApi(): ApiSet? {
        return retrofit?.create(ApiSet::class.java)
    }

    companion object {

        private val url = "http://192.168.29.68:8000/"
        private var clientobject: ApiController? = null
        private var retrofit: Retrofit? = null

        @Synchronized
        fun getInstance(): ApiController? {
            if (clientobject == null) clientobject = ApiController()
            return clientobject
        }
    }
}
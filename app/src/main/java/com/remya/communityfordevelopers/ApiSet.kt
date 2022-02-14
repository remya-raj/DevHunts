package com.remya.communityfordevelopers

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiSet {

    @GET("api/allSkills")
    fun getAllSkills(): Call<ArrayList<Skills>>

    @POST("api/auth/signup")
    fun registerUser(): Call<ArrayList<Skills>>
}
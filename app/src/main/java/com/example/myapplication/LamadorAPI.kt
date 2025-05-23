package com.example.myapplication

import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LlamadorAPI {
    @GET("user/{id}")
    suspend fun getUser(@Path("id") id:String) : Response<User>
//el suspend es lo mismo que el asinc en el js}
package com.dicoding.retrofit_practice

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/posts")
    fun getAllPosts(
    ): Call<List<Response>>
}
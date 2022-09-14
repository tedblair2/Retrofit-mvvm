package com.example.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    val retrofitPosts= Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URl)
        .build()

    val data by lazy{
        retrofitPosts.create(ApiInterface::class.java)
    }
    val api=Client(data)

}
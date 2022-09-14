package com.example.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("character/{character_id}")
    suspend fun getData(@Path("character_id") character_id: Int): Response<User>
}
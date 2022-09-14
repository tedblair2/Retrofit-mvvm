package com.example.retrofit

class SharedRepository {

    suspend fun getCharacter(id:Int):User?{
        val response=Retrofit.api.getCharacter(id)

        if (response.failed){
            return null
        }
        if (!response.isSuccessful){
            return null
        }

        return response.body
    }
}
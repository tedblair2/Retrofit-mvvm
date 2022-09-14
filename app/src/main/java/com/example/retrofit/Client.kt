package com.example.retrofit

import retrofit2.Response

class Client(private val service:ApiInterface) {

    suspend fun getCharacter(id:Int): ResponseClass<User> {
        return safeApiCall { service.getData(id) }
    }
    inline fun<T> safeApiCall(apicall: ()-> Response<T>):ResponseClass<T>{
        return try {
            ResponseClass.success(apicall.invoke())
        }catch (e:Exception){
            ResponseClass.failure(e)
        }
    }
}
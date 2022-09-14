package com.example.retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SharedViewModel:ViewModel() {

    private val repository=SharedRepository()

    private val liveData=MutableLiveData<User?>()
    val characterliveData:LiveData<User?> = liveData

    fun refresh(id:Int){
        viewModelScope.launch {
            val response=repository.getCharacter(id)
            liveData.postValue(response)
        }
    }

}
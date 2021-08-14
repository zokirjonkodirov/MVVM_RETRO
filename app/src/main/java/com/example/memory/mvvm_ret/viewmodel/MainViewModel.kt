package com.example.memory.mvvm_ret.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memory.mvvm_ret.model.Post
import com.example.memory.mvvm_ret.repository.MainRepository
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * @author user
 * @date 14.08.2021
 */
class MainViewModel(private val repository: MainRepository): ViewModel() {

    val response = MutableLiveData<Response<Post>>()
    val dResponse = MutableLiveData<Response<Post>>()

    fun getPost() {
        viewModelScope.launch {
            val myResponse: Response<Post> = repository.getPost()

            response.value = myResponse
        }
    }

    fun getPost(number: Int) {
        viewModelScope.launch {
            val myResponse: Response<Post> = repository.getPost2(number)

            dResponse.value = myResponse
        }
    }
}
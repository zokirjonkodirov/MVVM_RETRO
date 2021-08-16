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
    val myCustomPosts = MutableLiveData<Response<List<Post>>>()
    val sortedCustomResponse = MutableLiveData<Response<List<Post>>>()

    fun pushPost(post: Post) {
        viewModelScope.launch {
            val myResponse = repository.pushPost(post)
            response.value = myResponse
        }
    }

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

    fun getCustomPosts(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val myResponse: Response<List<Post>> = repository.getCustomPosts(userId, sort, order)

            myCustomPosts.value = myResponse
        }
    }

    fun getCustomPosts2(userId: Int, order: Map<String, String>) {
        viewModelScope.launch {
            val sortedResponse: Response<List<Post>> = repository.getCustomPosts2(userId, order)

            sortedCustomResponse.value = sortedResponse
        }
    }
}
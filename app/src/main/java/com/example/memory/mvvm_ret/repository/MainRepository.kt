package com.example.memory.mvvm_ret.repository

import com.example.memory.mvvm_ret.api.RetrofitInstance
import com.example.memory.mvvm_ret.model.Post
import retrofit2.Response

/**
 * @author user
 * @date 14.08.2021
 */
class MainRepository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }
}
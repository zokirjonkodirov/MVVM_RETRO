package com.example.memory.mvvm_ret.api

import com.example.memory.mvvm_ret.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author user
 * @date 14.08.2021
 */
interface Api {

    @GET("posts/2")
    suspend fun getPost(): Response<Post>

    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number: Int
    ): Response<Post>
}
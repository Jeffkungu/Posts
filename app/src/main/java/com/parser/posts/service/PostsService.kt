package com.parser.posts.service

import com.parser.posts.model.Posts
import retrofit2.Response
import retrofit2.http.GET

interface PostsService {

    // Suspend modifier allows us to use couroutines with Retrofit
    @GET("/posts")
    suspend fun getPosts(): Response<Posts>
}
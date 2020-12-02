package com.parser.posts.service

import com.google.gson.GsonBuilder
import com.parser.posts.utils.ConstantValues
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostsRetrofitInstance {
    // Companion object helps us to have one instance of Retrofit
    companion object{
        fun getRetrofitInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(ConstantValues.POSTS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }
}
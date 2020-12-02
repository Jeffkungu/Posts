package com.parser.posts.dependencyinjection.core

import com.google.gson.GsonBuilder
import com.parser.posts.service.PostsService
import com.parser.posts.utils.ConstantValues
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class PostRetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ConstantValues.POSTS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    @Singleton
    @Provides
    fun providePostsService(retrofit: Retrofit): PostsService{
        return retrofit.create(PostsService::class.java)
    }
}
package com.parser.posts.repository.data

import com.parser.posts.database.PostEntity

interface LocalDataSource {
    suspend fun getAllPosts(): List<PostEntity>
    suspend fun getPostsBellow45(): List<PostEntity>
    suspend fun getPostsBetween30and90(): List<PostEntity>
    suspend fun addPosts(posts: List<PostEntity>)
    suspend fun deletePosts()
}
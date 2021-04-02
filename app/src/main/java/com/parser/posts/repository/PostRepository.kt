package com.parser.posts.repository

import com.parser.posts.database.PostEntity

interface PostRepository {
    suspend fun getAllPosts(): List<PostEntity>?
    suspend fun getPostsBellow45(): List<PostEntity>?
    suspend fun getPostsBetween25and100(): List<PostEntity>?
    suspend fun addPosts(): List<PostEntity>?
}
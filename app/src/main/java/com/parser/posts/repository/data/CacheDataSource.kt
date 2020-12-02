package com.parser.posts.repository.data

import com.parser.posts.database.PostEntity

interface CacheDataSource {
    suspend fun getAllPostsFromCache(): List<PostEntity>
    suspend fun addPostsToCache(posts: List<PostEntity>)
}
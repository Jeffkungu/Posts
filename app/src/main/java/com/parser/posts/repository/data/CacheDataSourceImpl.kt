package com.parser.posts.repository.data

import com.parser.posts.database.PostEntity

class CacheDataSourceImpl : CacheDataSource {
    private var postsList = ArrayList<PostEntity>()

    override suspend fun getAllPostsFromCache(): List<PostEntity> {
        return postsList
    }

    override suspend fun addPostsToCache(posts: List<PostEntity>) {
        postsList.clear()
        postsList = ArrayList(posts)
    }
}
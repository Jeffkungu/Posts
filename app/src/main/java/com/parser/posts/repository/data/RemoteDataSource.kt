package com.parser.posts.repository.data

import com.parser.posts.database.PostEntity
import com.parser.posts.model.Posts
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getPostsFromServer(): Response<Posts>
}
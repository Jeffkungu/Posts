package com.parser.posts.repository.data

import com.parser.posts.database.PostEntity
import com.parser.posts.model.Posts
import com.parser.posts.service.PostsService
import retrofit2.Response

class RemoteDatasourceImpl(private val postsService: PostsService) : RemoteDataSource {
    override suspend fun getPostsFromServer(): Response<Posts> {
        return postsService.getPosts()
    }
}
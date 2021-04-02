package com.parser.posts.repository.data

import com.parser.posts.database.PostDAO
import com.parser.posts.database.PostEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocatDataSourceImpl(private val postDao : PostDAO): LocalDataSource {
    override suspend fun getAllPosts(): List<PostEntity> {
        return postDao.getAllPosts()
    }

    override suspend fun getPostsBellow45(): List<PostEntity> {
        return postDao.getPostsBellow45()
    }

    override suspend fun getPostsBetween25and100(): List<PostEntity> {
        return postDao.getPostsBetween25and100()
    }

    override suspend fun addPosts(posts: List<PostEntity>) {
        CoroutineScope(Dispatchers.IO).launch {
            postDao.insertPost(posts)
        }
    }

    override suspend fun deletePosts() {
        postDao.deleteAllPosts()
    }
}
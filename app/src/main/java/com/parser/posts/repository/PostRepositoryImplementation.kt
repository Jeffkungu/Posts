package com.parser.posts.repository

import android.util.Log
import com.parser.posts.database.PostEntity
import com.parser.posts.model.Posts
import com.parser.posts.repository.data.CacheDataSource
import com.parser.posts.repository.data.LocalDataSource
import com.parser.posts.repository.data.RemoteDataSource
import retrofit2.Response
import java.lang.Exception

class PostRepositoryImplementation(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val cacheDataSource: CacheDataSource
) : PostRepository {

    private var postList: List<PostEntity> = ArrayList()

    override suspend fun getAllPosts(): List<PostEntity>? {
        try {
            val response: Response<Posts> = remoteDataSource.getPostsFromServer()
            val body: Posts? = response.body()

            if(body!=null){
                postList = body
            }
        } catch(exception : Exception) {
            Log.i("ERROR", exception.message.toString())
        }

        // Store posts in local database and cache
        addPosts()
        cacheDataSource.addPostsToCache(postList)

        return postList
    }

    override suspend fun getPostsBellow45(): List<PostEntity>? {
        try {
            postList = localDataSource.getPostsBellow45()
        } catch(exception : Exception) {
            Log.i("ERROR", exception.message.toString())
        }

        if(postList.size > 0){
            return postList
        } else {
            Log.i("ERROR", "List Is Empty")
            getAllPosts()
        }

        return postList
    }

    override suspend fun getPostsBetween25and100(): List<PostEntity>? {
        try {
            postList = localDataSource.getPostsBetween25and100()
        } catch(exception : Exception) {
            Log.i("ERROR", exception.message.toString())
        }

        if(postList.size > 0){
            return postList
        } else {
            getAllPosts()
        }

        return postList
    }

    override suspend fun addPosts(): List<PostEntity>? {
        localDataSource.deletePosts()
        localDataSource.addPosts(postList)
        return postList
    }

    suspend fun getPostsFremCache(): List<PostEntity>? {
        try {
            postList = cacheDataSource.getAllPostsFromCache()
        } catch(exception : Exception) {
            Log.i("ERROR", exception.message.toString())
        }

        if(postList.size > 0){
            return postList
        } else {
            getAllPosts()
        }

        return postList
    }
}
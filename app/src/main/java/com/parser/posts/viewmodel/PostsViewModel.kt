package com.parser.posts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.parser.posts.database.PostEntity
import com.parser.posts.repository.UseCases

class PostsViewModel(private val useCases: UseCases): ViewModel() {

    fun getAllPosts(): LiveData<List<PostEntity>?> = liveData {
        val postList: List<PostEntity>? = useCases.getAllPosts()
        emit(postList)
    }

    fun getPostsBellow45(): LiveData<List<PostEntity>?> = liveData {
        val postList: List<PostEntity>? = useCases.getPostsBellow45()
        emit(postList)
    }

    fun getPostsBetwen25and100(): LiveData<List<PostEntity>?> = liveData {
        val postList: List<PostEntity>? = useCases.getPostsBetween25and100()
        emit(postList)
    }
}
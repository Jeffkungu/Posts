package com.parser.posts.repository

import com.parser.posts.database.PostEntity

class UseCases(private val postRepository: PostRepository) {
    suspend fun getAllPosts(): List<PostEntity>? = postRepository.getAllPosts()
    suspend fun getPostsBellow45(): List<PostEntity>? = postRepository.getPostsBellow45()
    suspend fun getPostsBetween30and90(): List<PostEntity>? = postRepository.getPostsBetween30and90()
}
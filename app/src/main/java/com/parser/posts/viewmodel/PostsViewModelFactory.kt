package com.parser.posts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.parser.posts.repository.UseCases

class PostsViewModelFactory(private val useCases: UseCases): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostsViewModel(useCases) as T
    }
}
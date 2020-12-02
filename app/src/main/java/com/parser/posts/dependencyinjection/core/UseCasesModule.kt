package com.parser.posts.dependencyinjection.core

import com.parser.posts.repository.PostRepository
import com.parser.posts.repository.UseCases
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCasesModule {

    @Provides
    fun providesUseCases(postRepository: PostRepository): UseCases {
        return UseCases(postRepository)
    }
}
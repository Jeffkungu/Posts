package com.parser.posts.dependencyinjection.subcomponent

import com.parser.posts.repository.UseCases
import com.parser.posts.viewmodel.PostsViewModelFactory
import dagger.Module
import dagger.Provides

// This helps us
@Module
class PostModule {

    @PostScope
    @Provides
    fun providePostViewModelFactory(useCases: UseCases): PostsViewModelFactory{
        return PostsViewModelFactory(useCases)
    }
}
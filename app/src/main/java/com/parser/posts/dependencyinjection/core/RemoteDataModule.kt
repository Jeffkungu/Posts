package com.parser.posts.dependencyinjection.core

import com.parser.posts.repository.data.RemoteDataSource
import com.parser.posts.repository.data.RemoteDatasourceImpl
import com.parser.posts.service.PostsService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun providesRemoteDataSourceImpl(postsService: PostsService): RemoteDataSource{
        return RemoteDatasourceImpl(postsService)
    }
}
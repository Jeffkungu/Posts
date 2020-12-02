package com.parser.posts.dependencyinjection.core

import com.parser.posts.repository.PostRepository
import com.parser.posts.repository.PostRepositoryImplementation
import com.parser.posts.repository.data.CacheDataSource
import com.parser.posts.repository.data.LocalDataSource
import com.parser.posts.repository.data.RemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesPostRepositoryImpl(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource,
        cacheDataSource: CacheDataSource
    ): PostRepository{
        return PostRepositoryImplementation(remoteDataSource, localDataSource, cacheDataSource)
    }
}
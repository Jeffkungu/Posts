package com.parser.posts.dependencyinjection.core

import com.parser.posts.repository.data.CacheDataSource
import com.parser.posts.repository.data.CacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideCacheDataIml(): CacheDataSource{
        return CacheDataSourceImpl()
    }
}
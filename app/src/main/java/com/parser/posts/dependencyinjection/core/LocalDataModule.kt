package com.parser.posts.dependencyinjection.core

import com.parser.posts.database.PostDAO
import com.parser.posts.repository.data.LocalDataSource
import com.parser.posts.repository.data.LocatDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providesLocalDataImpl(postDao : PostDAO): LocalDataSource{
        return LocatDataSourceImpl(postDao)
    }
}
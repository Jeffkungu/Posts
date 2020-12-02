package com.parser.posts.dependencyinjection.core

import android.content.Context
import androidx.room.Room
import com.parser.posts.database.PostDAO
import com.parser.posts.database.PostDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providePostDataBase(context: Context): PostDatabase{
        return Room.databaseBuilder(context, PostDatabase::class.java, "post_database")
            .build()
    }

    @Singleton
    @Provides
    fun providePostDao(postDatabase: PostDatabase): PostDAO{
        return postDatabase.postDao()
    }
}
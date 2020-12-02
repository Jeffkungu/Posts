package com.parser.posts.dependencyinjection.core

import android.content.Context
import com.parser.posts.dependencyinjection.subcomponent.PostSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [PostSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun providesApplicationContext(): Context{
        return context.applicationContext
    }
}
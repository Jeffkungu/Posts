package com.parser.posts.dependencyinjection.subcomponent

import com.parser.posts.view.PostsActivity
import dagger.Subcomponent

@PostScope
@Subcomponent(modules = [PostModule::class])
interface PostSubComponent {
    fun inject(postsActivity: PostsActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): PostSubComponent
    }
}
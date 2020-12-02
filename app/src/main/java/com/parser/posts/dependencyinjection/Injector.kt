package com.parser.posts.dependencyinjection

import com.parser.posts.dependencyinjection.subcomponent.PostSubComponent

interface Injector {
    fun createPostSubComponent(): PostSubComponent
}
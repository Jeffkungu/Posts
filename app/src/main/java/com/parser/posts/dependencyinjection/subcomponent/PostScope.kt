package com.parser.posts.dependencyinjection.subcomponent

import javax.inject.Scope

// Used to annotate the PostFactoryModule to give it a Scope tied to PostActivity lifecycle
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class PostScope
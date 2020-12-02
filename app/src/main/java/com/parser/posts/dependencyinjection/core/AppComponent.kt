package com.parser.posts.dependencyinjection.core

import com.parser.posts.dependencyinjection.subcomponent.PostSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
AppModule::class,
CacheDataModule::class,
DatabaseModule::class,
LocalDataModule::class,
PostRetrofitModule::class,
RemoteDataModule::class,
RepositoryModule::class,
UseCasesModule::class
])
interface AppComponent {

    // Get the sub components
    fun postSubComponent(): PostSubComponent.Factory
}
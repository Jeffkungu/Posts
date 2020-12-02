package com.parser.posts.viewmodel

import android.app.Application
import com.parser.posts.dependencyinjection.Injector
import com.parser.posts.dependencyinjection.core.AppComponent
import com.parser.posts.dependencyinjection.core.AppModule
import com.parser.posts.dependencyinjection.core.DaggerAppComponent
import com.parser.posts.dependencyinjection.subcomponent.PostSubComponent

class App: Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()

    }

    override fun createPostSubComponent(): PostSubComponent {
        return  appComponent.postSubComponent().create()
    }
}
package com.example.appmovie

import android.app.Application
import com.example.appmovie.di.DaggerAppComponent
import com.example.appmovie.di.module.MovieRepositoryModule

class AppMovie : Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().movieRepositoryModule(MovieRepositoryModule(this))
    }

}
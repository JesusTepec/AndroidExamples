package com.example.appmovie.di

import com.example.appmovie.di.module.MovieRepositoryModule
import com.example.appmovie.viewmodel.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules=[MovieRepositoryModule::class])
@Singleton
interface AppComponent {

    fun inject(viewModel: MainViewModel)
}
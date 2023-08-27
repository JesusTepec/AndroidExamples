package com.example.appmovie.di.module

import android.content.Context
import com.example.appmovie.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class MovieRepositoryModule(@Named("context") val context: Context) {

    @Singleton
    @Provides
    fun movieRepository(): MovieRepository {
        return MovieRepository(context)
    }


}
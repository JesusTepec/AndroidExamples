package com.example.apptest.di

import android.content.Context
import com.example.apptest.repository.MovementRepository
import com.example.apptest.rest.MovementsService
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class MovementsRepositoryModule(var context: Context) {

    @Provides
    @Singleton
    fun provideMovementService(client: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://api.finerio.mx/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(client)
        .build()
        .create(MovementsService::class.java)

    @Provides
    @Singleton
    fun provideApiRepository(movementsService: MovementsService) = MovementRepository(movementsService)

}
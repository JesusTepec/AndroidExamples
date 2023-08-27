package com.example.apptest.di

import android.content.Context
import com.example.apptest.repository.UserRepository
import com.example.apptest.rest.UserService
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class UserRepositoryModule(var context: Context) {

    @Provides
    @Singleton
    fun provideHttpClient() = OkHttpClient.Builder()
        .addInterceptor(ChuckInterceptor(context))
        .build()

    @Provides
    @Singleton
    fun provideApiService(client: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://api.finerio.mx/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(client)
        .build()
        .create(UserService::class.java)

    @Provides
    @Singleton
    fun provideApiRepository(userService: UserService) = UserRepository(userService)

}
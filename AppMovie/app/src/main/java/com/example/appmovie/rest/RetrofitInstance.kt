package com.example.appmovie.rest

import android.content.Context
import com.example.appmovie.AppMovie
import com.readystatesoftware.chuck.ChuckInterceptor
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        private var retrofit: Retrofit? = null
        private const val url = "https://api.themoviedb.org"

        private fun getInstance(context: Context): Retrofit {
            val client = OkHttpClient.Builder()
                .addInterceptor(ChuckInterceptor(context))
                .build()
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(url)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build()
            }
            return retrofit!!

        }

        fun getApiService(context: Context): ApiService = getInstance(context).create(ApiService::class.java)
    }
}
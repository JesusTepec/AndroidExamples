package com.example.appmovie.repository

import android.content.Context
import com.example.appmovie.rest.ApiService
import com.example.appmovie.rest.RetrofitInstance
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import model.MovieResponse
import javax.inject.Inject

class MovieRepository @Inject constructor (context: Context) {

    private var restApi: ApiService = RetrofitInstance.getApiService(context)

    fun getPlayNow(token: String, api_key: String, language: String, page: Int): Single<MovieResponse> {
        return restApi.getNowPlaying(token, api_key, language, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
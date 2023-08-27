package repository

import android.content.Context
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import model.PokemonResponse
import rest.RestApi

class PokemonRepository(context: Context) {

    private val restApi = RestApi.getService(context)

    fun getPokemons(): Single<PokemonResponse> {
        return restApi.getPokemons()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
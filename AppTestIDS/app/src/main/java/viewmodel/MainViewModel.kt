package viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import model.Pokemon
import model.PokemonResponse
import repository.PokemonRepository

class MainViewModel(context: Context) : ViewModel() {

    private var repository: PokemonRepository = PokemonRepository(context)

    fun getPokemons() : MutableLiveData<List<Pokemon>> {
        val liveDataResponse = MutableLiveData<List<Pokemon>>()
        repository.getPokemons().subscribeWith(object : DisposableSingleObserver<PokemonResponse>(){
            override fun onSuccess(response: PokemonResponse?) {
                response?.let {
                    if(it.results.isNotEmpty()) {
                        liveDataResponse.postValue(it.results)
                    }
                }
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

        })
        return liveDataResponse
    }

}
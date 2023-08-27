package com.example.apptest.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.apptest.model.Movement
import com.example.apptest.model.MovementsRequest
import com.example.apptest.model.MovementsResponse
import com.example.apptest.repository.MovementRepository
import com.example.apptest.repository.UserRepository
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import javax.inject.Inject

class MainViewModel @Inject constructor(val userRepository: UserRepository, val movementRepository: MovementRepository) : BaseViewModel() {

    fun getMovements(): MutableLiveData<List<Movement>?> {
        val responseLiveData = MutableLiveData<List<Movement>?>()
        val request = MovementsRequest().apply {
            offset = 0
            max = 10
        }
        movementRepository.getMovements(sessionToken, "c5dd9df8-066a-4c39-9559-5ed07eb13f05", request).subscribeWith(object : DisposableSingleObserver<MovementsResponse>() {
            override fun onSuccess(t: MovementsResponse) {
               if(t.size > 0 && t.data.isNotEmpty()) {
                   responseLiveData.postValue(t.data)
               }
            }

            override fun onError(e: Throwable?) {
                responseLiveData.postValue(null)
            }

        })
        return responseLiveData
    }


}
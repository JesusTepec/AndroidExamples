package com.example.apptest.repository

import com.example.apptest.model.MovementsRequest
import com.example.apptest.model.MovementsResponse
import com.example.apptest.rest.MovementsService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MovementRepository @Inject constructor(var movementsService: MovementsService) {

    fun getMovements(token: String, userId: String, movementsRequest: MovementsRequest): Single<MovementsResponse> {
        return movementsService.getMovements(
            token,
            userId,
            movementsRequest.deep,
            movementsRequest.offset,
            movementsRequest.max,
            movementsRequest.includeCharges,
            movementsRequest.includeDeposits,
            movementsRequest.includeDuplicates,
            movementsRequest.startDate,
            movementsRequest.endDate
        )
            .observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}
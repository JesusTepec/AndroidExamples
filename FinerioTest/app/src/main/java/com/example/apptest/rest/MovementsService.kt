package com.example.apptest.rest

import com.example.apptest.model.MovementsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MovementsService {


    @GET("users/{user_id}/movements")
    fun getMovements(
        @Header("Authorization") token: String,
        @Path("user_id") userId: String,
        @Query("deep") deep: Boolean,
        @Query("offset") offset: Int,
        @Query("max") max: Int,
        @Query("includeCharges") includeCharges: Boolean,
        @Query("includeDeposits") includeDeposits: Boolean,
        @Query("includeDuplicates") includeDuplicates: Boolean,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String
    ): Single<MovementsResponse>
}
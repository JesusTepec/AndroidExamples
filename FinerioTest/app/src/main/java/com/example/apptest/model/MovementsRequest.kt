package com.example.apptest.model

data class MovementsRequest(
    val deep: Boolean = true,
    var offset: Int = 0,
    var max: Int = 0,
    val includeCharges: Boolean = true,
    val includeDeposits: Boolean = true,
    val includeDuplicates: Boolean = false,
    val startDate: String = "2020-7-01",
    val endDate: String = "2021-6-16"
)

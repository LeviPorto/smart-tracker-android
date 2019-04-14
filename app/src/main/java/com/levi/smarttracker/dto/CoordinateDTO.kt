package com.levi.smarttracker.dto

import java.util.*

data class CoordinateDTO (
    val lat: Double,
    val lng: Double,
    val date: Date,
    val deviceId: Int,
    val id: String? = null
)
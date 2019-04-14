package com.levi.smarttracker.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by levip on 23/03/2019.
 */
data class Coordinate (

        @SerializedName("lat") @Expose val lat: Double,
        @SerializedName("lng") @Expose val lng: Double,
        @SerializedName("date") @Expose val date: Date,
        @SerializedName("deviceId") @Expose val deviceId: Int,
        @SerializedName("id") @Expose val id: String? = null

)
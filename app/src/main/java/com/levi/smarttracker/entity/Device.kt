package com.levi.smarttracker.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by levip on 23/03/2019.
 */
 data class Device (
        @SerializedName("imei") @Expose val imei: String,
        @SerializedName("user") @Expose val user: User? = null,
        @SerializedName("id") @Expose val id: Int? = null
)
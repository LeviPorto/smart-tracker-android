package com.levi.smarttracker.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by levip on 28/03/2019.
 */
data class TokenDTO(
        @SerializedName("token") @Expose val token: String,
        @SerializedName("userId") @Expose val userId: Int
)
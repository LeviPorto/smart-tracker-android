package com.levi.smarttracker.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by levip on 28/03/2019.
 */
data class JWTAuthenticationDTO(@SerializedName("username") @Expose val username: String? = null,
                                @SerializedName("password") @Expose val password: String? = null)
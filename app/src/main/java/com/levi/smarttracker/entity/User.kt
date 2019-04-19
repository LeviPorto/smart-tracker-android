package com.levi.smarttracker.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.levi.smarttracker.enumerated.PerfilEnum


/**
 * Created by levip on 23/03/2019.
 */
data class User(
        @SerializedName("username") @Expose val username: String,
        @SerializedName("password") @Expose val password: String,
        @SerializedName("email") @Expose val email: String,
        @SerializedName("perfil") @Expose val perfil : PerfilEnum? = null,
        @SerializedName("id") @Expose val id: Int? = null
)
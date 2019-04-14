package com.levi.smarttracker.api.service

import com.levi.smarttracker.dto.JWTAuthenticationDTO
import com.levi.smarttracker.dto.TokenDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by levip on 28/03/2019.
 */
interface LoginApiService {

    @POST("/login")
    fun login(@Body jwtAuthenticationDTO: JWTAuthenticationDTO?): Call<TokenDTO>

}
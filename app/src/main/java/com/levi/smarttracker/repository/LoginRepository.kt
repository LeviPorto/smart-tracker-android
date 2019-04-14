package com.levi.smarttracker.repository

import com.levi.smarttracker.api.service.LoginApiService
import com.levi.smarttracker.dto.JWTAuthenticationDTO
import com.levi.smarttracker.dto.TokenDTO
import retrofit2.Call

/**
 * Created by levip on 23/03/2019.
 */
class LoginRepository(private val loginApiService: LoginApiService) {

    fun retrieveUser(username : String, password : String) : Call<TokenDTO> {
        return loginApiService.login(JWTAuthenticationDTO(username, password))
    }

}
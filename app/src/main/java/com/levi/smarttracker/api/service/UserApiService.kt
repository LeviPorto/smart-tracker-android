package com.levi.smarttracker.api.service

import com.levi.smarttracker.dto.UserDTO
import com.levi.smarttracker.entity.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiService {

    @POST("/smartTracker/user")
    fun create(@Body userDTO: UserDTO) : Call<User>

}
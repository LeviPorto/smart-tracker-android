package com.levi.smarttracker.repository

import com.levi.smarttracker.api.service.UserApiService
import com.levi.smarttracker.dto.UserDTO
import com.levi.smarttracker.entity.User
import retrofit2.Call

class UserRepository(private val userApiService: UserApiService) {

    fun create(userDTO: UserDTO) : Call<User> = userApiService.create(userDTO)

}
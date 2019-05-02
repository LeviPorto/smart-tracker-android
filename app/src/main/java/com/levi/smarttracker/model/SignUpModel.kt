package com.levi.smarttracker.model

import com.levi.smarttracker.dto.UserDTO
import com.levi.smarttracker.entity.User
import com.levi.smarttracker.mvp.SignUpMVP
import com.levi.smarttracker.repository.UserRepository
import retrofit2.Call

class SignUpModel(private val repository: UserRepository) : SignUpMVP.Model {

    override fun createUser(userDTO: UserDTO) : Call<User> = repository.create(userDTO)

}
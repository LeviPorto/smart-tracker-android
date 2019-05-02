package com.levi.smarttracker.mvp

import com.levi.smarttracker.dto.UserDTO
import com.levi.smarttracker.entity.User
import retrofit2.Call

interface SignUpMVP {

    interface View {

        fun getUsername(): String
        fun getPassword(): String
        fun getEmail(): String
        fun showSuccessfullySignUpMessage()
        fun showErrorSignUpMessage()
        fun changeToLoginActivity()

    }

    interface Presenter {

        fun registerUser()
        fun setView(view: SignUpMVP.View)

    }

    interface Model {

        fun createUser(userDTO: UserDTO) : Call<User>

    }

}
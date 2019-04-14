package com.levi.smarttracker.mvp

import com.levi.smarttracker.dto.DeviceDTO
import com.levi.smarttracker.dto.TokenDTO
import com.levi.smarttracker.entity.Device
import retrofit2.Call

/**
 * Created by levip on 19/03/2019.
 */
interface LoginMVP {


    interface View {

        fun getUsername(): String
        fun getPassword(): String
        fun showSuccessfullyLoginMessage()
        fun showErrorMessage()

    }

    interface Presenter {

        fun login()

        fun setView(view: LoginMVP.View)

    }

    interface Model {

        fun loadUser(username: String, password: String) : Call<TokenDTO>

        fun createDevice(deviceDTO: DeviceDTO) : Call<Device>

    }


}
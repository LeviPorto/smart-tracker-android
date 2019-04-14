package com.levi.smarttracker.model

import com.levi.smarttracker.dto.DeviceDTO
import com.levi.smarttracker.dto.TokenDTO
import com.levi.smarttracker.entity.Device
import com.levi.smarttracker.mvp.LoginMVP
import com.levi.smarttracker.repository.DeviceRepository
import com.levi.smarttracker.repository.LoginRepository
import retrofit2.Call

/**
 * Created by levip on 23/03/2019.
 */
class LoginModel(private val repository: LoginRepository, private val deviceRepository : DeviceRepository) : LoginMVP.Model {

    override fun loadUser(username: String, password: String) : Call<TokenDTO> = repository.retrieveUser(username, password)

    override fun createDevice(deviceDTO: DeviceDTO) : Call<Device> = deviceRepository.create(deviceDTO)

}
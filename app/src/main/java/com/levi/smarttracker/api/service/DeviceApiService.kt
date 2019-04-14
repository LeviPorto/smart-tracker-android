package com.levi.smarttracker.api.service

import com.levi.smarttracker.dto.DeviceDTO
import com.levi.smarttracker.entity.Device
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DeviceApiService {

    @POST("/smartTracker/device")
    fun create(@Body deviceDTO: DeviceDTO) : Call<Device>

}
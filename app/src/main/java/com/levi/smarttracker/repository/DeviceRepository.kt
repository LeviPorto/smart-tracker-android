package com.levi.smarttracker.repository

import com.levi.smarttracker.api.service.DeviceApiService
import com.levi.smarttracker.dto.DeviceDTO
import com.levi.smarttracker.entity.Device
import retrofit2.Call

class DeviceRepository(private val deviceApiService: DeviceApiService) {

    fun create(deviceDTO: DeviceDTO) : Call<Device> = deviceApiService.create(deviceDTO)


}
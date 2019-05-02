package com.levi.smarttracker.repository

import com.levi.smarttracker.api.service.CoordinateApiService
import com.levi.smarttracker.dto.CoordinateDTO
import com.levi.smarttracker.entity.Coordinate
import retrofit2.Call

class CoordinateRepository(private val coordinateApiService: CoordinateApiService) {

    fun sendCoordinate(coordinateDTO: CoordinateDTO): Call<Coordinate> = coordinateApiService.sendCoordinate(coordinateDTO)

}
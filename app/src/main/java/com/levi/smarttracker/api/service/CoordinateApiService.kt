package com.levi.smarttracker.api.service

import com.levi.smarttracker.dto.CoordinateDTO
import com.levi.smarttracker.entity.Coordinate
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CoordinateApiService {

    @POST("/smartTracker/coordinate")
    fun sendCoordinate(@Body coordinateDTO: CoordinateDTO): Call<Coordinate>

}
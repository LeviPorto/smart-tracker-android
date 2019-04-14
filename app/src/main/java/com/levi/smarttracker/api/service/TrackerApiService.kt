package com.levi.smarttracker.api.service

import com.levi.smarttracker.dto.CoordinateDTO
import com.levi.smarttracker.entity.Coordinate
import retrofit2.http.POST

interface TrackerApiService {

    @POST("/smartTrack/coordinate")
    fun sendCoordinate(coordinateDTO: CoordinateDTO): Coordinate

}
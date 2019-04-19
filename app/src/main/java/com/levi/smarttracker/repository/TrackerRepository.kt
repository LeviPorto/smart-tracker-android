package com.levi.smarttracker.repository

import com.levi.smarttracker.api.service.TrackerApiService
import com.levi.smarttracker.dto.CoordinateDTO
import com.levi.smarttracker.entity.Coordinate

class TrackerRepository(private val trackerApiService: TrackerApiService) {

    fun sendCoordinate(coordinateDTO: CoordinateDTO): Coordinate = trackerApiService.sendCoordinate(coordinateDTO)

}
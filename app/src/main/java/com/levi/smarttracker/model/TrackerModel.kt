package com.levi.smarttracker.model

import com.levi.smarttracker.dto.CoordinateDTO
import com.levi.smarttracker.entity.Coordinate
import com.levi.smarttracker.mvp.TrackerMVP
import com.levi.smarttracker.repository.CoordinateRepository
import retrofit2.Call

class TrackerModel(private val repository: CoordinateRepository) : TrackerMVP.Model {

    override fun sendCoordinate(coordinateDTO: CoordinateDTO): Call<Coordinate> =
            repository.sendCoordinate(coordinateDTO)

}
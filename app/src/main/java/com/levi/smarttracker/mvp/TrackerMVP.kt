package com.levi.smarttracker.mvp

import com.levi.smarttracker.dto.CoordinateDTO
import com.levi.smarttracker.entity.Coordinate
import retrofit2.Call

interface TrackerMVP {

    interface View {

        fun showTrackerBeginMessage()
        fun showTrackerEndMessage()

    }

    interface Presenter {

        fun track(coordinateDTO: CoordinateDTO)
        fun beginTracker()
        fun endTracker()
        fun setView(view: TrackerMVP.View)

    }

    interface Model {

        fun sendCoordinate(coordinateDTO: CoordinateDTO) : Call<Coordinate>

    }

}
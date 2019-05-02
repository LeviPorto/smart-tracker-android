package com.levi.smarttracker.presenter

import android.content.Context
import com.levi.smarttracker.dto.CoordinateDTO
import com.levi.smarttracker.dto.DeviceDTO
import com.levi.smarttracker.entity.Coordinate
import com.levi.smarttracker.mvp.TrackerMVP
import com.levi.smarttracker.util.PreferenceUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrackerPresenter(private val model : TrackerMVP.Model, private val context : Context)  : TrackerMVP.Presenter {

    private var view: TrackerMVP.View? = null

    override fun track(coordinateDTO: CoordinateDTO) {
        model.sendCoordinate(coordinateDTO).enqueue(object: Callback<Coordinate> {
            override fun onResponse(call: Call<Coordinate>, response: Response<Coordinate>) {

            }

            override fun onFailure(call: Call<Coordinate>,
                                   t: Throwable?) {

            }

        })
    }

    override fun setView(view: TrackerMVP.View) {
        this.view = view
    }

    override fun beginTracker() {
        PreferenceUtil.setBooleanPreference(context, "SEND_COORDINATE", true)
        view!!.showTrackerBeginMessage()
    }

    override fun endTracker() {
        PreferenceUtil.setBooleanPreference(context, "SEND_COORDINATE", false)
        view!!.showTrackerEndMessage()
    }


}
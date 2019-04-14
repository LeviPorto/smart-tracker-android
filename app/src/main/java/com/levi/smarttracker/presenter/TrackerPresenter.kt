package com.levi.smarttracker.presenter

import android.content.Context
import com.levi.smarttracker.mvp.TrackerMVP
import com.levi.smarttracker.util.PreferenceUtil

class TrackerPresenter(private val context : Context)  : TrackerMVP.Presenter {

    private var view: TrackerMVP.View? = null

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
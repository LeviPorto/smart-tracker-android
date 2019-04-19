package com.levi.smarttracker.mvp

class TrackerMVP {

    interface View {

        fun showTrackerBeginMessage()
        fun showTrackerEndMessage()

    }

    interface Presenter {

        fun beginTracker()
        fun endTracker()
        fun setView(view: TrackerMVP.View)

    }

    interface Model

}
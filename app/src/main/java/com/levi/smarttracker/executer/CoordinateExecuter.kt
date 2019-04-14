package com.levi.smarttracker.executer

import android.os.AsyncTask
import com.levi.smarttracker.repository.TrackerRepository

open class CoordinateExecuter() : AsyncTask<Void, Void, String>() {

    override fun doInBackground(vararg p0: Void?): String {
        return "oi"
        //trackerRepository.sendCoordinate()
    }


}
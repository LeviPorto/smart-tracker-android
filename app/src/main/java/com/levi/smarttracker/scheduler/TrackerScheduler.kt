package com.levi.smarttracker.scheduler

import android.app.job.JobParameters
import android.app.job.JobService
import android.widget.Toast
import com.levi.smarttracker.executer.CoordinateExecuter

class TrackerScheduler : JobService() {

    private lateinit var coordinateExecutor : CoordinateExecuter

    override fun onStopJob(p0: JobParameters?): Boolean {
        coordinateExecutor.cancel(true)
        return false
    }

    override fun onStartJob(p0: JobParameters?): Boolean {
        coordinateExecutor = object : CoordinateExecuter(){
            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)

                Toast.makeText(applicationContext, result, Toast.LENGTH_SHORT).show()
                jobFinished(p0, false)
            }
        }
        coordinateExecutor.execute()
        return true
    }
}
package com.levi.smarttracker.activity

import android.annotation.SuppressLint
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.levi.smarttracker.R
import com.levi.smarttracker.mvp.TrackerMVP
import com.levi.smarttracker.root.App
import com.levi.smarttracker.scheduler.TrackerScheduler
import javax.inject.Inject
import android.content.Intent
import com.levi.smarttracker.scheduler.TestScheduler


/**
 * Created by levip on 02/04/2019.
 */
class TrackerActivity:
        AppCompatActivity(), TrackerMVP.View {

    @JvmField @BindView(R.id.tracker_trigger_begin_btn) var beginTrackerBtn: Button? = null
    @JvmField @BindView(R.id.tracker_trigger_end_btn) var endTrackerBtn: Button? = null

    @JvmField @Inject var presenter: TrackerMVP.Presenter? = null

    private lateinit var jobScheduler: JobScheduler
    private lateinit var jobInfo: JobInfo

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tracker_trigger)
        (application as App).component!!.inject(this)
        ButterKnife.bind(this)

        var cn = ComponentName(this, TrackerScheduler::class.java)
        var builder: JobInfo.Builder = JobInfo.Builder(100, cn)
        builder.setMinimumLatency(5000)
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            builder.setTriggerContentMaxDelay(5000)
        }
        builder.setPersisted(true)
        jobInfo = builder.build()
        jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

        beginTrackerBtn!!.setOnClickListener {
            presenter!!.beginTracker()
        }

        endTrackerBtn!!.setOnClickListener {
            presenter!!.endTracker()
        }

        startService(Intent(this, TestScheduler::class.java))


    }



    override fun onStart() {
        super.onStart()
        presenter!!.setView(this)
    }

    override fun showTrackerBeginMessage() {
        jobScheduler.schedule(jobInfo)
        Toast.makeText(this, "Tracker have started!", Toast.LENGTH_SHORT).show()
    }

    override fun showTrackerEndMessage() {
        jobScheduler.cancel(100)
        Toast.makeText(this, "Tracker have finished", Toast.LENGTH_SHORT).show()
    }
}
package com.levi.smarttracker.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.levi.smarttracker.R
import com.levi.smarttracker.mvp.TrackerMVP
import com.levi.smarttracker.root.App
import javax.inject.Inject
import android.content.Intent
import com.levi.smarttracker.helper.ClickHelper
import com.levi.smarttracker.scheduler.TrackerScheduler


/**
 * Created by levip on 02/04/2019.
 */
class TrackerActivity:
        AppCompatActivity(), TrackerMVP.View, ClickHelper {

    @JvmField @BindView(R.id.tracker_trigger_begin_btn) var beginTrackerBtn: Button? = null
    @JvmField @BindView(R.id.tracker_trigger_end_btn) var endTrackerBtn: Button? = null

    @JvmField @Inject var presenter: TrackerMVP.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tracker_trigger)
        (application as App).component!!.inject(this)
        ButterKnife.bind(this)

        setOnClick()

        startService(Intent(this, TrackerScheduler::class.java))

    }

    override fun setOnClick() {
        beginTrackerBtn!!.setOnClickListener {
            presenter!!.beginTracker()
        }

        endTrackerBtn!!.setOnClickListener {
            presenter!!.endTracker()
        }
    }

    override fun onStart() {
        super.onStart()
        presenter!!.setView(this)
    }

    override fun showTrackerBeginMessage() {
        Toast.makeText(this, "Tracker have started!", Toast.LENGTH_SHORT).show()
    }

    override fun showTrackerEndMessage() {
        Toast.makeText(this, "Tracker have finished", Toast.LENGTH_SHORT).show()
    }
}
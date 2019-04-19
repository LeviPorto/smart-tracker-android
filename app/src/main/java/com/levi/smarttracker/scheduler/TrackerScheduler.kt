package com.levi.smarttracker.scheduler

import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.IBinder
import android.support.v4.app.ActivityCompat
import android.util.Log



/**
 * Created by roberto on 9/29/16.
 */

class TrackerScheduler : Service() {

    private var mLocationManager: LocationManager? = null

    private var mLocationListeners = arrayOf(LocationListener(LocationManager.PASSIVE_PROVIDER))

    private val tag = "TrackerScheduler"

    private val location_interval = 1000
    private val location_distance = 10f

    private inner class LocationListener(provider: String) : android.location.LocationListener {

        internal var mLastLocation: Location

        init {
            Log.e(tag, "LocationListener $provider")
            mLastLocation = Location(provider)
        }

        override fun onLocationChanged(location: Location) {
            Log.e(tag, "onLocationChanged: $location")
            mLastLocation.set(location)
        }

        override fun onProviderDisabled(provider: String) {
            Log.e(tag, "onProviderDisabled: $provider")
        }

        override fun onProviderEnabled(provider: String) {
            Log.e(tag, "onProviderEnabled: $provider")
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {
            Log.e(tag, "onStatusChanged: $provider")
        }
    }

    override fun onBind(arg0: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        return Service.START_STICKY
    }

    override fun onCreate() {
        initializeLocationManager()

        try {
            mLocationManager!!.requestLocationUpdates(
                    LocationManager.PASSIVE_PROVIDER, location_interval.toLong(),
                    location_distance, mLocationListeners[0]
            )
        } catch (ex: java.lang.SecurityException) {
            Log.i(tag, "fail to request location update, ignore", ex)
        } catch (ex: IllegalArgumentException) {
            Log.d(tag, "network provider does not exist, " + ex.message)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (mLocationManager != null) {
            for (i in mLocationListeners.indices) {
                try {
                    if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED &&
                            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED) {
                        return
                    }
                    mLocationManager!!.removeUpdates(mLocationListeners[i])
                } catch (ex: Exception) {
                    Log.i(tag, "fail to remove location listener, ignore", ex)
                }

            }
        }
    }

    private fun initializeLocationManager() {
        if (mLocationManager == null) {
            mLocationManager = applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        }
    }

}
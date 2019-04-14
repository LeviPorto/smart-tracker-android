package com.levi.smarttracker.util

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

object PermissionUtil {

    private const val RECORD_REQUEST_CODE = 101

    fun requestPermission(context: Context, activity: Activity, permission : String) {
        if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, arrayOf(permission), RECORD_REQUEST_CODE)
        }
    }

}
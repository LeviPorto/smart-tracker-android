package com.levi.smarttracker.util

import android.annotation.SuppressLint
import android.content.Context
import android.telephony.TelephonyManager



object ImeiUtil {

    @SuppressLint("MissingPermission")
    fun getImei(context: Context) : String{
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        return telephonyManager.deviceId
    }

}
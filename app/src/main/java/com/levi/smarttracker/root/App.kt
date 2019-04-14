package com.levi.smarttracker.root

import android.app.Application
import android.content.Context
import com.levi.smarttracker.api.module.DeviceApiModule
import com.levi.smarttracker.api.module.LoginApiModule
import com.levi.smarttracker.api.module.TrackerApiModule
import com.levi.smarttracker.module.LoginModule
import com.levi.smarttracker.module.TrackerModule

class App : Application() {

    var component: ApplicationComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .loginApiModule(LoginApiModule())
                .loginModule(LoginModule())
                .trackerModule(TrackerModule())
                .trackerApiModule(TrackerApiModule())
                .deviceApiModule(DeviceApiModule(this))
                .build()
    }

}

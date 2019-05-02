package com.levi.smarttracker.root

import android.app.Application
import com.levi.smarttracker.api.module.DeviceApiModule
import com.levi.smarttracker.api.module.LoginApiModule
import com.levi.smarttracker.api.module.CoordinateApiModule
import com.levi.smarttracker.api.module.UserApiModule
import com.levi.smarttracker.module.LoginModule
import com.levi.smarttracker.module.SignUpModule
import com.levi.smarttracker.module.TrackerModule

class App : Application() {

    var component: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .loginApiModule(LoginApiModule(this))
                .loginModule(LoginModule())
                .trackerModule(TrackerModule())
                .coordinateApiModule(CoordinateApiModule(this))
                .deviceApiModule(DeviceApiModule(this))
                .userApiModule(UserApiModule(this))
                .signUpModule(SignUpModule())
                .build()
    }

}

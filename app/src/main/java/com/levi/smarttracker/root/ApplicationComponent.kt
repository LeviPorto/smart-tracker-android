package com.levi.smarttracker.root

import com.levi.smarttracker.activity.LoginActivity
import com.levi.smarttracker.activity.TrackerActivity
import com.levi.smarttracker.api.module.DeviceApiModule
import com.levi.smarttracker.api.module.LoginApiModule
import com.levi.smarttracker.api.module.TrackerApiModule
import com.levi.smarttracker.module.LoginModule
import com.levi.smarttracker.module.TrackerModule
import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = [ApplicationModule::class, LoginApiModule::class, LoginModule::class,
    TrackerModule::class, TrackerApiModule::class, DeviceApiModule::class])
interface ApplicationComponent {

    fun inject(target: LoginActivity)

    fun inject(target: TrackerActivity)

}


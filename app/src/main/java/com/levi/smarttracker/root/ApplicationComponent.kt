package com.levi.smarttracker.root

import com.levi.smarttracker.activity.LoginActivity
import com.levi.smarttracker.activity.SignUpActivity
import com.levi.smarttracker.activity.TrackerActivity
import com.levi.smarttracker.api.module.DeviceApiModule
import com.levi.smarttracker.api.module.LoginApiModule
import com.levi.smarttracker.api.module.CoordinateApiModule
import com.levi.smarttracker.api.module.UserApiModule
import com.levi.smarttracker.module.LoginModule
import com.levi.smarttracker.module.SignUpModule
import com.levi.smarttracker.module.TrackerModule
import com.levi.smarttracker.scheduler.TrackerScheduler
import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = [ApplicationModule::class, LoginApiModule::class, LoginModule::class,
    TrackerModule::class, CoordinateApiModule::class, DeviceApiModule::class, UserApiModule::class, SignUpModule::class])
interface ApplicationComponent {

    fun inject(target: LoginActivity)

    fun inject(target: TrackerActivity)

    fun inject(target: TrackerScheduler)

    fun inject(target: SignUpActivity)

}


package com.levi.smarttracker.module

import android.content.Context
import com.levi.smarttracker.api.service.DeviceApiService
import com.levi.smarttracker.api.service.LoginApiService
import com.levi.smarttracker.model.LoginModel
import com.levi.smarttracker.mvp.LoginMVP
import com.levi.smarttracker.presenter.LoginPresenter
import com.levi.smarttracker.repository.DeviceRepository
import com.levi.smarttracker.repository.LoginRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by levip on 19/03/2019.
 */

@Module
class LoginModule {

    @Provides
    fun provideLoginPresenter(loginModel: LoginMVP.Model, context: Context): LoginMVP.Presenter {
        return LoginPresenter(loginModel, context)
    }

    @Provides
    fun provideLoginModel(repository: LoginRepository, deviceRepository: DeviceRepository): LoginMVP.Model {
        return LoginModel(repository, deviceRepository)
    }

    @Singleton
    @Provides
    fun provideLoginRepository(loginApiService: LoginApiService): LoginRepository {
        return LoginRepository(loginApiService)
    }

    @Singleton
    @Provides
    fun provideDeviceRepository(deviceApiService : DeviceApiService): DeviceRepository {
        return DeviceRepository(deviceApiService)
    }


}

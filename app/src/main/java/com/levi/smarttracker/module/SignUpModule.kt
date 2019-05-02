package com.levi.smarttracker.module

import com.levi.smarttracker.api.service.UserApiService
import com.levi.smarttracker.model.SignUpModel
import com.levi.smarttracker.mvp.SignUpMVP
import com.levi.smarttracker.presenter.SignUpPresenter
import com.levi.smarttracker.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SignUpModule {

    @Provides
    fun providePresenter(model : SignUpMVP.Model): SignUpMVP.Presenter {
        return SignUpPresenter(model)
    }

    @Provides
    fun provideModel(repository: UserRepository): SignUpMVP.Model {
        return SignUpModel(repository)
    }

    @Singleton
    @Provides
    fun provideRepository(userApiService: UserApiService): UserRepository {
        return UserRepository(userApiService)
    }

}
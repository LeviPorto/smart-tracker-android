package com.levi.smarttracker.module

import android.content.Context
import com.levi.smarttracker.api.service.LoginApiService
import com.levi.smarttracker.api.service.TrackerApiService
import com.levi.smarttracker.model.LoginModel
import com.levi.smarttracker.model.TrackerModel
import com.levi.smarttracker.mvp.LoginMVP
import com.levi.smarttracker.mvp.TrackerMVP
import com.levi.smarttracker.presenter.TrackerPresenter
import com.levi.smarttracker.repository.LoginRepository
import com.levi.smarttracker.repository.TrackerRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TrackerModule {

    @Provides
    fun provideTrackerPresenter(context: Context): TrackerMVP.Presenter {
        return TrackerPresenter(context)
    }

    @Provides
    fun provideTrackerModel(repository: TrackerRepository): TrackerMVP.Model {
        return TrackerModel(repository)
    }

    @Singleton
    @Provides
    fun provideRepo(trackerApiService: TrackerApiService): TrackerRepository {
        return TrackerRepository(trackerApiService)
    }

}
package com.levi.smarttracker.module

import android.content.Context
import com.levi.smarttracker.api.service.CoordinateApiService
import com.levi.smarttracker.model.TrackerModel
import com.levi.smarttracker.mvp.TrackerMVP
import com.levi.smarttracker.presenter.TrackerPresenter
import com.levi.smarttracker.repository.CoordinateRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TrackerModule {

    @Provides
    fun providePresenter(model : TrackerMVP.Model, context: Context): TrackerMVP.Presenter {
        return TrackerPresenter(model, context)
    }

    @Provides
    fun provideModel(repository: CoordinateRepository): TrackerMVP.Model {
        return TrackerModel(repository)
    }

    @Singleton
    @Provides
    fun provideTrackerRepository(coordinateApiService: CoordinateApiService): CoordinateRepository {
        return CoordinateRepository(coordinateApiService)
    }

}
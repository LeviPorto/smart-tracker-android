package com.levi.smarttracker.model

import com.levi.smarttracker.mvp.TrackerMVP
import com.levi.smarttracker.repository.TrackerRepository

class TrackerModel(private val repository: TrackerRepository) : TrackerMVP.Model
package com.levi.smarttracker.dto

data class DeviceDTO (
        val imei: String,
        val userId: Int? = null,
        val id: Int? = null
)

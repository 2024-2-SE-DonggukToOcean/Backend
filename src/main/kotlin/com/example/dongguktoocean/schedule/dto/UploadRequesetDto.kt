package com.example.dongguktoocean.schedule.dto

data class UploadRequestDto(
    val ship_id: Long,
    val captain: String,
    val loadingPort: String,
    val destinationPort: String,
    val departureTime: String,
    val arrivalTime: String,
    val shippingCompany: String
)

data class ScheduleUploadResponseDto(
    val success: Boolean,
    val error: String?
)
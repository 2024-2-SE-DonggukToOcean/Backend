package com.example.dongguktoocean.dto

data class SearchRequestDto(
    val departureDate: String,
    val loadingPort: String,
    val destinationPort: String
)

data class ShipScheduleResponseDto(
    val shipCode: String,
    val captain: String,
    val loadingPort: String,
    val destinationPort: String,
    val departureTime: String,
    val arrivalTime: String
)

data class SearchResponseDto(
    val responseDto: List<ShipScheduleResponseDto>,
    val success: Boolean,
    val error: String?
)

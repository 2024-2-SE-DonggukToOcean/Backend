package com.example.dongguktoocean.schedule.dto

import com.example.dongguktoocean.schedule.domain.Schedule

data class SearchRequestDto(
    val departureDate: String,
    val loadingPort: String,
    val destinationPort: String
)

data class SearchResponseDto(
    val responseDto: List<Schedule>,
    val success: Boolean,
    val error: String?
)

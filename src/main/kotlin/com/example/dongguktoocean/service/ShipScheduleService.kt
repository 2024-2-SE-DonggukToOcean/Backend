package com.example.dongguktoocean.service

import com.example.dongguktoocean.dto.SearchRequestDto
import com.example.dongguktoocean.dto.SearchResponseDto
import com.example.dongguktoocean.dto.ShipScheduleResponseDto
import com.example.dongguktoocean.repository.ShipScheduleRepository
import org.springframework.stereotype.Service

@Service
class ShipScheduleService(
    private val repository: ShipScheduleRepository
) {
    fun searchSchedules(request: SearchRequestDto): SearchResponseDto {
        val schedules: List<ShipScheduleResponseDto> = repository.findSchedules(
            request.departureDate,
            request.loadingPort,
            request.destinationPort
        )
        return SearchResponseDto(
            responseDto = schedules,
            success = true,
            error = null
        )
    }
}

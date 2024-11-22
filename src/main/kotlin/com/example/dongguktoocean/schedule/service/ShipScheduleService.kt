package com.example.dongguktoocean.schedule.service

import com.example.dongguktoocean.schedule.dto.SearchRequestDto
import com.example.dongguktoocean.schedule.dto.SearchResponseDto
import com.example.dongguktoocean.schedule.dto.ShipScheduleResponseDto
import com.example.dongguktoocean.schedule.repository.ShipScheduleRepository
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

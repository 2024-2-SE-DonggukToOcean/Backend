package com.example.dongguktoocean.schedule.controller

import com.example.dongguktoocean.schedule.dto.SearchRequestDto
import com.example.dongguktoocean.schedule.dto.SearchResponseDto
import com.example.dongguktoocean.schedule.service.ShipScheduleService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/schedules")
class ShipScheduleController(
    private val service: ShipScheduleService
) {
    @PostMapping("/search")
    fun searchSchedules(@RequestBody request: SearchRequestDto): SearchResponseDto {
        return service.searchSchedules(request)
    }
}

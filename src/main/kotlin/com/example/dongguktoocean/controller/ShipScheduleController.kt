package com.example.dongguktoocean.controller

import com.example.dongguktoocean.dto.SearchRequestDto
import com.example.dongguktoocean.dto.SearchResponseDto
import com.example.dongguktoocean.service.ShipScheduleService
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

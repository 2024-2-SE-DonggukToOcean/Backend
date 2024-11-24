package com.example.dongguktoocean.schedule.controller

//import com.example.dongguktoocean.schedule.dto.ScheduleUploadResponseDto
import com.example.dongguktoocean.schedule.dto.ScheduleUploadResponseDto
import com.example.dongguktoocean.schedule.dto.SearchRequestDto
import com.example.dongguktoocean.schedule.dto.SearchResponseDto
import com.example.dongguktoocean.schedule.dto.UploadRequestDto
//import com.example.dongguktoocean.schedule.dto.UploadRequestDto
import com.example.dongguktoocean.schedule.service.ShipScheduleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/schedule")
class ShipScheduleController(
    private val service: ShipScheduleService
) {
    @PostMapping("list/search")
    fun searchSchedules(@RequestBody request: SearchRequestDto): SearchResponseDto {
        return service.searchSchedules(request)
    }

    @PostMapping("upload")
    fun uploadSchedule(@RequestBody request: UploadRequestDto): ScheduleUploadResponseDto {
        return service.uploadSchedule(request)
    }
}


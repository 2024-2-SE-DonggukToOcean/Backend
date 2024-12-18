package com.example.dongguktoocean.schedule.controller

//import com.example.dongguktoocean.schedule.dto.ScheduleUploadResponseDto
import com.example.dongguktoocean.document.dto.ResponseDto
import com.example.dongguktoocean.schedule.dto.*
//import com.example.dongguktoocean.schedule.dto.UploadRequestDto
import com.example.dongguktoocean.schedule.service.ShipScheduleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpStatus

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
    @GetMapping("/list/{shipping_company_id}")
    fun getSchedulesByCompanyId(
        @PathVariable shipping_company_id: Long
    ): ResponseEntity<ResponseDto<List<ShipScheduleResponseDto>>> {
        return try {
            val response = service.getSchedulesByCompanyId(shipping_company_id)
            ResponseDto.success(response)
        } catch (e: IllegalArgumentException) {
            ResponseDto.error(HttpStatus.BAD_REQUEST, e.message ?: "Invalid request")
        }
    }


}


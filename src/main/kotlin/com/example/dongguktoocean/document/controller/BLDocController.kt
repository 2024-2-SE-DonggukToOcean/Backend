package com.example.dongguktoocean.document.controller

import com.example.dongguktoocean.document.dto.BLNumberRequest
import com.example.dongguktoocean.document.dto.ResponseDto
import com.example.dongguktoocean.document.dto.ScheduleResponse
import com.example.dongguktoocean.document.service.BLDocService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class BLDocController(private val blDocService: BLDocService) {

    @PostMapping("/cargolocation")
    fun getScheduleDetails(@RequestBody request: BLNumberRequest): ResponseEntity<ResponseDto<ScheduleResponse>> {
        return try {
            val scheduleResponse = blDocService.getScheduleDetails(request.BLNumber)
            ResponseDto.success(scheduleResponse) // 성공 응답
        } catch (e: IllegalArgumentException) {
            ResponseDto.error(HttpStatus.BAD_REQUEST, e.message ?: "Invalid request") // 오류 응답
        }
    }
}
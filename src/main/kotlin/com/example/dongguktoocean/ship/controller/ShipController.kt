package com.example.dongguktoocean.ship.controller

import com.example.dongguktoocean.ship.dto.ShipRequestDto
import com.example.dongguktoocean.ship.dto.ShipResponseDto
import com.example.dongguktoocean.ship.service.ShipService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ship")
class ShipController(
    private val shipService: ShipService
) {

    @PostMapping("/register")
    fun registerShip(@RequestBody requestDto: ShipRequestDto): ResponseEntity<ShipResponseDto> {
        val responseDto = shipService.registerShip(requestDto)
        return ResponseEntity.ok(responseDto)
    }
}
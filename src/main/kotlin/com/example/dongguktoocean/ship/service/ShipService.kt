package com.example.dongguktoocean.ship.service

import com.example.dongguktoocean.ship.domain.Ship
import com.example.dongguktoocean.ship.dto.ShipRequestDto
import com.example.dongguktoocean.ship.dto.ShipResponseDto
import com.example.dongguktoocean.ship.repository.ShipRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class ShipService(
    private val shipRepository: ShipRepository
) {

    @Transactional
    fun registerShip(requestDto: ShipRequestDto): ShipResponseDto {
        // Ship 엔티티 생성
        val ship = Ship(
            ship_id = requestDto.ship_id,
            name = requestDto.ship_name,
            location = requestDto.ship_from,
            ship_capacity = requestDto.ship_capacity
        )

        // 데이터 저장
        shipRepository.save(ship)

        // 성공 응답 반환
        return ShipResponseDto(
            error = 0,
            success = true
        )
    }
}
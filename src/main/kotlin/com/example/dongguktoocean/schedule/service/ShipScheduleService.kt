package com.example.dongguktoocean.schedule.service

import com.example.dongguktoocean.schedule.domain.Schedule
import com.example.dongguktoocean.schedule.dto.*
import com.example.dongguktoocean.schedule.repository.ShipScheduleRepository
import com.example.dongguktoocean.ship.repository.ShipRepository
import com.example.dongguktoocean.user.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class ShipScheduleService(
    private val userRepository: UserRepository,
    private val scheduleRepository: ShipScheduleRepository,
    private val shipRepository: ShipRepository
) {
    fun searchSchedules(request: SearchRequestDto): SearchResponseDto {
        val schedules: List<Schedule> = scheduleRepository.findSchedules(
            request.loadingPort,
            request.destinationPort,
            request.departureDate


        )
        return SearchResponseDto(
            responseDto = schedules,
            success = true,
            error = null
        )
    }

    @Transactional
    fun uploadSchedule(request: UploadRequestDto) : ScheduleUploadResponseDto{
        val ship = shipRepository.findById(request.ship_id).orElseThrow{ IllegalArgumentException("해당 ID의 선박이 존재하지 않습니다.") }

        val schedule = Schedule(

            ship_id=ship,
            captain = request.captain,
            loadingPort = request.loadingPort,
            destinationPort = request.destinationPort,
            departureTime = request.departureTime,
            arrivalTime = request.arrivalTime,
            shippingCompany = request.shippingCompany
        )
        scheduleRepository.save(schedule)
        val response : ScheduleUploadResponseDto = ScheduleUploadResponseDto(
            true,
            "요청에 성공하였습니다."
        )
        return response
    }
}

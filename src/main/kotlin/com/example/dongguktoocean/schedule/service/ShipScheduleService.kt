package com.example.dongguktoocean.schedule.service

import com.example.dongguktoocean.schedule.domain.Schedule
import com.example.dongguktoocean.schedule.dto.*
import com.example.dongguktoocean.schedule.repository.ShipScheduleRepository
import com.example.dongguktoocean.user.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class ShipScheduleService(
    private val userRepository: UserRepository,
    private val scheduleRepository: ShipScheduleRepository
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
        val schedule: Schedule = Schedule(
            null,
            request.shipCode,
            request.captain,
            request.loadingPort,
            request.destinationPort,
            request.departureTime,
            request.arrivalTime,
            request.shippingCompany
        )
        scheduleRepository.save(schedule)
        val response : ScheduleUploadResponseDto = ScheduleUploadResponseDto(
            true,
            "요청에 성공하였습니다."
        )
        return response
    }
}

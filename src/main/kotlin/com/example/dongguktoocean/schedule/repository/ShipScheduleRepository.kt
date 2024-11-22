package com.example.dongguktoocean.schedule.repository

import com.example.dongguktoocean.schedule.dto.ShipScheduleResponseDto
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface ShipScheduleRepository {
    @Select("""
        SELECT
            ship_code AS shipCode,
            captain,
            loading_port AS loadingPort,
            destination_port AS destinationPort,
            departure_time AS departureTime,
            arrival_time AS arrivalTime
        FROM ship_schedule
        WHERE loading_port = #{loadingPort}
          AND destination_port = #{destinationPort}
          
          AND departure_time::DATE >= TO_DATE(#{departureDate}, 'YYYY-MM-DD')

    """)
    fun findSchedules(
        @Param("departureDate") departureDate: String,
        @Param("loadingPort") loadingPort: String,
        @Param("destinationPort") destinationPort: String
    ): List<ShipScheduleResponseDto>
}

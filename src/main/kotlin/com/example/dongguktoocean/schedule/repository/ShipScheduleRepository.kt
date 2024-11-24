package com.example.dongguktoocean.schedule.repository

import com.example.dongguktoocean.schedule.domain.Schedule
import org.apache.ibatis.annotations.Param
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query


interface ShipScheduleRepository : JpaRepository<Schedule, Long> {

    @Query("""
        SELECT s 
        FROM Schedule s 
        WHERE s.loadingPort = :loadingPort
          AND s.destinationPort = :destinationPort
          AND s.departureTime >= :departureDate
    """)
    fun findSchedules(
        @Param("loadingPort") loadingPort: String,
        @Param("destinationPort") destinationPort: String,
        @Param("departureDate") departureDate: String
    ): List<Schedule>
}

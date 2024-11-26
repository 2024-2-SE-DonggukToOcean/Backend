package com.example.dongguktoocean.schedule.repository

import com.example.dongguktoocean.schedule.domain.Schedule
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ScheduleQueryRepository : JpaRepository<Schedule, Long> {
    // shippingCompany로 ShipSchedule 조회
    fun findByShippingCompany(shippingCompany: String): List<Schedule>
}
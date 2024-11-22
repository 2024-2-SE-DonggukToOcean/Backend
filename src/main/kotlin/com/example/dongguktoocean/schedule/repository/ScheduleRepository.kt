package com.example.dongguktoocean.schedule.repository

import com.example.dongguktoocean.schedule.domain.Schedule
import org.springframework.data.jpa.repository.JpaRepository

interface ScheduleRepository : JpaRepository<Schedule, Long>

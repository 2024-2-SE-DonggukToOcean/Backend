package com.example.dongguktoocean.repository

import com.example.dongguktoocean.domain.Schedule
import org.springframework.data.jpa.repository.JpaRepository

interface ScheduleRepository : JpaRepository<Schedule, Long>

package com.example.dongguktoocean.booking.repository

import com.example.dongguktoocean.booking.domain.Booking
import org.springframework.data.jpa.repository.JpaRepository

interface BookingRepository : JpaRepository<Booking, Long>{
    fun findByCargoId(cargoId: Long): Booking?
}
package com.example.dongguktoocean.ship.repository

import com.example.dongguktoocean.ship.domain.Ship
import org.springframework.data.jpa.repository.JpaRepository


interface ShipRepository : JpaRepository<Ship, Long> // ship_id를 PK로 사용
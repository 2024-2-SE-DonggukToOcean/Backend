package com.example.dongguktoocean.ship.repository

import com.example.dongguktoocean.ship.domain.Ship
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository


@Repository
interface ShipRepository : JpaRepository<Ship, String> // ship_id를 PK로 사용
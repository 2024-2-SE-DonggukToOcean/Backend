package com.example.dongguktoocean.ship.dto

data class ShipRequestDto(
    val ship_id: String,
    val ship_name: String,
    val ship_capacity: String,
    val ship_from: String
)
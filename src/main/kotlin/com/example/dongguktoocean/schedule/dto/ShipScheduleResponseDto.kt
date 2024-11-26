package com.example.dongguktoocean.schedule.dto

data class ShipScheduleResponseDto(
    val id: Long,
    val ship_id: String,
    val departure_time: String,
    val arrival_time: String,
    val load_port: String,
    val dest_port: String,
    val shipping_company: String // shipping_company 추가
)

package com.example.dongguktoocean.dto

data class InvoiceDocRequest(
    val num: String,
    val name: String,
    val cargo_quantity: Int,
    val cargo_type: String,
    val cargo_weight: Int,
    val price: Int,
    val sender: String,
    val receiver: String,
    val shipScheduleId: Long
)

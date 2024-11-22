package com.example.dongguktoocean.schedule.domain

import jakarta.persistence.*


@Entity
@Table(name = "Ship_Schedule")
data class Schedule(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val shipCode: String,

    @Column(nullable = false)
    val captain: String,

    @Column(nullable = false)
    val loadingPort: String,

    @Column(nullable = false)
    val destinationPort: String,

    @Column(nullable = false)
    val departureTime: String,

    @Column(nullable = false)
    val arrivalTime: String
)

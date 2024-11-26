package com.example.dongguktoocean.schedule.domain

import com.example.dongguktoocean.ship.domain.Ship
import jakarta.persistence.*


@Entity
@Table(name = "Ship_Schedule")
data class Schedule(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "ship_id", nullable = false) // 선박 스케줄 ID 외래키
    val ship_id: Ship, // Ship 엔티티 참조

    @Column(nullable = false)
    val captain: String,

    @Column(nullable = false)
    val loadingPort: String,

    @Column(nullable = false)
    val destinationPort: String,

    @Column(nullable = false)
    val departureTime: String,

    @Column(nullable = false)
    val arrivalTime: String,

    @Column(nullable = true)
    val shippingCompany: String
)

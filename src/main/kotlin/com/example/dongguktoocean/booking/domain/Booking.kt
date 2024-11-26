package com.example.dongguktoocean.booking.domain

import com.example.dongguktoocean.cargo.domain.Cargo
import com.example.dongguktoocean.container.domain.Container
import com.example.dongguktoocean.schedule.domain.Schedule
import jakarta.persistence.*

@Entity
@Table(name = "Booking")
data class Booking(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null, // 선박 예약 ID

    @Column(nullable = false)
    val status: String, // 상태

    @OneToOne
    @JoinColumn(name = "cargo_id", nullable = false) // 화물 ID 외래키
    val cargo: Cargo, // Cargo 엔티티 참조

    @OneToOne
    @JoinColumn(name = "container_id", nullable = true) // 컨테이너 ID 외래키 (nullable)
    val container: Container? = null, // Container 엔티티 참조 (nullable)

    @ManyToOne
    @JoinColumn(name = "ship_schedule_id", nullable = false) // 선박 스케줄 ID 외래키
    val shipSchedule: Schedule // ShipSchedule 엔티티 참조
)
package com.example.dongguktoocean.document.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "BL_Doc")
data class BLDoc(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val shipName: String, // 선박 명칭

    @Column(nullable = false)
    val national: String, // 국적

    @Column(nullable = false)
    val ton: Int, // 톤 수

    @Column(nullable = false)
    val cargoType: String, // 화물 종류

    @Column(nullable = false)
    val cargoWeight: Int, // 화물 중량

    @Column(nullable = false)
    val cargoQuantity: Int, // 화물 수량

    @Column(nullable = false)
    val receiver: String, // 수신자

    @Column(nullable = false)
    val sender: String, // 송신자

    @Column(nullable = false)
    val landPort: String, // 선적항

    @Column(nullable = false)
    val destPort: String, // 목적항

    @Column(nullable = false)
    val freightRate: Int, // 운임

    @Column(nullable = false)
    val issuanceLocation: String, // 발행지

    @Column(nullable = false)
    val issuanceDate: LocalDateTime // 발행연월일
)

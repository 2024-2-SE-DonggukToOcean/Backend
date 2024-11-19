package com.example.dongguktoocean.domain

import jakarta.persistence.*

@Entity
@Table(name = "Users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val type: String, // 종류
    @Column(nullable = false)
    val loginId: String, // 로그인 ID
    @Column(nullable = false)
    val loginPw: String, // 로그인 비밀번호
    @Column(nullable = false)
    val phone: String, // 전화번호
    @Column(nullable = false)
    val email: String // 이메일
)

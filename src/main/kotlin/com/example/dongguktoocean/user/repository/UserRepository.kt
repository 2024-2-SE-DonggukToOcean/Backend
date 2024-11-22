package com.example.dongguktoocean.user.repository


import com.example.dongguktoocean.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
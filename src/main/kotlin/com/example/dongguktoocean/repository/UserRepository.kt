package com.example.dongguktoocean.repository


import com.example.dongguktoocean.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
package com.example.dongguktoocean.repository

import com.example.dongguktoocean.domain.Cargo
import org.springframework.data.jpa.repository.JpaRepository

interface CargoRepository : JpaRepository<Cargo, Long>
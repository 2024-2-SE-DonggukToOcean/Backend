package com.example.dongguktoocean.container.repository


import com.example.dongguktoocean.container.domain.Container
import org.springframework.data.jpa.repository.JpaRepository

interface ContainerRepository : JpaRepository<Container, Long>
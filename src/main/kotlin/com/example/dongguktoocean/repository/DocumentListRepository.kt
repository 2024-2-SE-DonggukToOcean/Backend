package com.example.dongguktoocean.repository

import com.example.dongguktoocean.domain.DocumentList
import org.springframework.data.jpa.repository.JpaRepository

interface DocumentListRepository : JpaRepository<DocumentList, Long>
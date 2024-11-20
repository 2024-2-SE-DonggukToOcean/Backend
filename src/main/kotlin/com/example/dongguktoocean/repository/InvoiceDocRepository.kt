package com.example.dongguktoocean.repository

import com.example.dongguktoocean.domain.InvoiceDoc
import org.springframework.data.jpa.repository.JpaRepository

interface InvoiceDocRepository : JpaRepository<InvoiceDoc, Long>

package com.example.dongguktoocean.document.repository

import com.example.dongguktoocean.document.domain.InvoiceDoc
import org.springframework.data.jpa.repository.JpaRepository

interface InvoiceDocRepository : JpaRepository<InvoiceDoc, Long>

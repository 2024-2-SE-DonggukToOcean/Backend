package com.example.dongguktoocean.cargo.repository

import com.example.dongguktoocean.cargo.domain.Cargo
import org.springframework.data.jpa.repository.JpaRepository

interface CargoRepository : JpaRepository<Cargo, Long>{
    fun findByInvoiceDocId(invoiceDocId: Long): Cargo?
}
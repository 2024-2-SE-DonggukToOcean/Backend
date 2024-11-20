package com.example.dongguktoocean.service

import com.example.dongguktoocean.domain.InvoiceDoc
import com.example.dongguktoocean.dto.InvoiceDocRequest
import com.example.dongguktoocean.repository.InvoiceDocRepository
import com.example.dongguktoocean.repository.ScheduleRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InvoiceDocService(
    private val invoiceDocRepository: InvoiceDocRepository,
    private val scheduleRepository: ScheduleRepository
) {
    @Transactional
    fun createInvoiceDoc(request: InvoiceDocRequest) {
        // ShipSchedule 조회
        val shipSchedule = scheduleRepository.findById(request.shipScheduleId.toLong())
            .orElseThrow{IllegalArgumentException("해당 ID의 ShipSchedule이 존재하지 않습니다.")}


        // InvoiceDoc 생성
        val invoiceDoc = InvoiceDoc(
            num = request.num,
            name = request.name,
            cargoQuantity = request.cargo_quantity,
            cargoType = request.cargo_type,
            cargoWeight = request.cargo_weight,
            price = request.price,
            sender = request.sender,
            receiver = request.receiver,
            ship = shipSchedule.shipCode,
            load_port = shipSchedule.loadingPort,
            dest_port = shipSchedule.destinationPort,
        )

        val savedInvoiceDoc = invoiceDocRepository.save(invoiceDoc)

    }
}

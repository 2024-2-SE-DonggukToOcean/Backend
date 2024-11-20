package com.example.dongguktoocean.service

import com.example.dongguktoocean.domain.Cargo
import com.example.dongguktoocean.domain.DocumentList
import com.example.dongguktoocean.domain.InvoiceDoc
import com.example.dongguktoocean.dto.InvoiceDocRequest
import com.example.dongguktoocean.repository.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InvoiceDocService(
    private val invoiceDocRepository: InvoiceDocRepository,
    private val scheduleRepository: ScheduleRepository,
    private val userRepository: UserRepository,
    private val documentListRepository: DocumentListRepository,
    private val cargoRepository: CargoRepository
) {
    @Transactional
    fun createInvoiceDoc(id: Long, request: InvoiceDocRequest) {
        // ShipSchedule 조회
        val user = userRepository.findById(id)
            .orElseThrow { IllegalArgumentException("해당 ID의 유저가 존재하지 않습니다.") }

        val shipSchedule = scheduleRepository.findById(request.shipScheduleId)
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

        val documentList = DocumentList(
            user = user,
            invoiceDoc = savedInvoiceDoc,
            blDoc = null, // BLDoc 연결이 없는 경우 null
            status = "Created" // 초기 상태 설정
        )
        documentListRepository.save(documentList)

        val cargo = Cargo(
            invoiceDoc = savedInvoiceDoc,
            cargoQuantity = request.cargo_quantity,
            cargoType = request.cargo_type,
            cargoWeight = request.cargo_weight
        )
        cargoRepository.save(cargo)
    }
}

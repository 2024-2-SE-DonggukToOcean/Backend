package com.example.dongguktoocean.document.service

import com.example.dongguktoocean.booking.domain.Booking
import com.example.dongguktoocean.booking.repository.BookingRepository
import com.example.dongguktoocean.cargo.domain.Cargo
import com.example.dongguktoocean.cargo.repository.CargoRepository
import com.example.dongguktoocean.container.domain.Container
import com.example.dongguktoocean.container.repository.ContainerRepository
import com.example.dongguktoocean.document.domain.DocumentList
import com.example.dongguktoocean.document.domain.InvoiceDoc
import com.example.dongguktoocean.document.dto.InvoiceDocRequest
import com.example.dongguktoocean.document.repository.DocumentListRepository
import com.example.dongguktoocean.document.repository.InvoiceDocRepository
import com.example.dongguktoocean.schedule.repository.ScheduleRepository
import com.example.dongguktoocean.ship.repository.ShipRepository
import com.example.dongguktoocean.user.repository.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Private

@Service
class InvoiceDocService(
    private val invoiceDocRepository: InvoiceDocRepository,
    private val scheduleRepository: ScheduleRepository,
    private val userRepository: UserRepository,
    private val documentListRepository: DocumentListRepository,
    private val cargoRepository: CargoRepository,
    private val containerRepository: ContainerRepository,
    private val bookingRepository: BookingRepository
) {
    @Transactional
    fun createInvoiceDoc(id: Long, request: InvoiceDocRequest) {
        // ShipSchedule 조회
        val user = userRepository.findById(id)
            .orElseThrow { IllegalArgumentException("해당 ID의 유저가 존재하지 않습니다.") }

        val shipSchedule = scheduleRepository.findById(request.shipScheduleId)
            .orElseThrow{IllegalArgumentException("해당 ID의 ShipSchedule이 존재하지 않습니다.")}
        val ship = shipSchedule.ship_id


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
            ship = ship.name,
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
        val savedCargo=cargoRepository.save(cargo)

        val container = Container(
            field = "00",
            field2 = "00",
            ship = ship
        )
        val savedContainer = containerRepository.save(container)

        val booking = Booking(
            status = "대기",
            cargo = savedCargo,
            shipSchedule = shipSchedule,
            container =savedContainer

        )
        val savedBooking = bookingRepository.save(booking)

    }
}

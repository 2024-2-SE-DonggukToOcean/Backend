package com.example.dongguktoocean.document.service

import com.example.dongguktoocean.booking.repository.BookingRepository
import com.example.dongguktoocean.cargo.repository.CargoRepository
import com.example.dongguktoocean.document.repository.DocumentListRepository
import org.springframework.stereotype.Service
import com.example.dongguktoocean.schedule.repository.ScheduleRepository
import org.springframework.transaction.annotation.Transactional
import com.example.dongguktoocean.document.domain.DocumentList
import com.example.dongguktoocean.document.dto.ScheduleResponse

@Service
class BLDocService(
    private val documentListRepository: DocumentListRepository,
    private val cargoRepository: CargoRepository,
    private val bookingRepository: BookingRepository,
    private val scheduleRepository: ScheduleRepository
) {

    @Transactional(readOnly = true)
    fun getScheduleDetails(blDocId: Long): ScheduleResponse {
        // 1. DocumentList 조회
        val documentList: DocumentList = documentListRepository.findByBlDocId(blDocId)
            ?: throw IllegalArgumentException("해당 BLDoc ID와 연결된 문서 리스트가 없습니다.")

        // 2. 상업송장 정보 조회
        val invoiceDoc = documentList.invoiceDoc
            ?: throw IllegalArgumentException("해당 BLDoc ID와 연결된 상업송장이 없습니다.")

        // 3. Cargo 조회
        val cargo = cargoRepository.findByInvoiceDocId(invoiceDoc.id!!)
            ?: throw IllegalArgumentException("해당 상업송장 ID와 연결된 Cargo가 없습니다.")

        // 4. Booking 조회
        val booking = bookingRepository.findByCargoId(cargo.id!!)
            ?: throw IllegalArgumentException("해당 Cargo ID와 연결된 Booking이 없습니다.")

        // 5. ShipSchedule 조회
        val shipSchedule = scheduleRepository.findById(booking.shipSchedule.id!!)
            .orElseThrow { IllegalArgumentException("해당 Booking과 연결된 ShipSchedule이 없습니다.") }

        // 6. 응답 데이터 생성
        return ScheduleResponse(
            departureTime = shipSchedule.departureTime,
            arrivalTime = shipSchedule.arrivalTime
        )
    }
}
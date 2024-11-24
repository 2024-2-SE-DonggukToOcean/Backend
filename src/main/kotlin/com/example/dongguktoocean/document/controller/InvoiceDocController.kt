package com.example.dongguktoocean.document.controller

import com.example.dongguktoocean.document.dto.InvoiceDocRequest
import com.example.dongguktoocean.document.dto.ResponseDto
import com.example.dongguktoocean.document.service.InvoiceDocService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class InvoiceDocController(private val invoiceDocService: InvoiceDocService) {

    @PostMapping("/sendfile/{id}")
    fun createInvoiceDoc(
        @RequestBody request: InvoiceDocRequest,
        @PathVariable id : Long
    ): ResponseEntity<ResponseDto<Nothing>> {
        return try {
            invoiceDocService.createInvoiceDoc(id, request) // 서비스 실행

            ResponseDto.success(null) // 성공 응답
        } catch (e: IllegalArgumentException) {
            ResponseDto.error(HttpStatus.BAD_REQUEST, e.message ?: "Invalid request") // 오류 응답
        }
    }
}
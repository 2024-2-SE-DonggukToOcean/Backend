package com.example.dongguktoocean.controller

import com.example.dongguktoocean.dto.InvoiceDocRequest
import com.example.dongguktoocean.dto.ResponseDto
import com.example.dongguktoocean.service.InvoiceDocService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/user")
class InvoiceDocController(private val invoiceDocService: InvoiceDocService) {

    @PostMapping("/sendfile")
    fun createInvoiceDoc(@RequestBody request: InvoiceDocRequest): ResponseEntity<ResponseDto<Nothing>> {
        return try {
            invoiceDocService.createInvoiceDoc(request) // 서비스 실행

            ResponseDto.success(null) // 성공 응답
        } catch (e: IllegalArgumentException) {
            ResponseDto.error(HttpStatus.BAD_REQUEST, e.message ?: "Invalid request") // 오류 응답
        }
    }
}
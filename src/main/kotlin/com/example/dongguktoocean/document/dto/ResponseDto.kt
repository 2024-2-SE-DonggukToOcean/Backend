package com.example.dongguktoocean.document.dto

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class ResponseDto<T>(
    val success: Boolean,
    val responseDto: T? = null,
    val error: ExceptionDto? = null
) {
    companion object {
        fun <T> success(data: T?= null): ResponseEntity<ResponseDto<T>> {
            return ResponseEntity.ok(ResponseDto(success = true, responseDto = data))
        }

        fun <T> error(status: HttpStatus, message: String): ResponseEntity<ResponseDto<T>> {
            return ResponseEntity
                .status(status)
                .body(ResponseDto(success = false, error = ExceptionDto(message)))
        }
    }
}

data class ExceptionDto(
    val message: String
)
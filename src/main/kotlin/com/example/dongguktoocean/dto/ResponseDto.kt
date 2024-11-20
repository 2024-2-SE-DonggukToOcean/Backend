package com.example.dongguktoocean.dto

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class ResponseDto<T>(
    val isSuccess: Boolean,
    val responseDto: T? = null,
    val error: ExceptionDto? = null
) {
    companion object {
        fun <T> success(data: T?= null): ResponseEntity<ResponseDto<T>> {
            return ResponseEntity.ok(ResponseDto(isSuccess = true, responseDto = data))
        }

        fun error(status: HttpStatus, message: String): ResponseEntity<ResponseDto<Nothing>> {
            return ResponseEntity
                .status(status)
                .body(ResponseDto(isSuccess = false, error = ExceptionDto(message)))
        }
    }
}

data class ExceptionDto(
    val message: String
)
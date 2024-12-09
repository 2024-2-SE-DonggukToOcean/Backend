package com.example.dongguktoocean.document.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class BLNumberRequest(
    @JsonProperty("BLNumber") val BLNumber: Long
)

package com.example.demo

import jakarta.validation.constraints.Email

data class Domain (
    @field:Email
    val email: String
)
package com.example.demo

import jakarta.validation.Valid
import org.springframework.stereotype.Repository
import org.springframework.validation.annotation.Validated

@Repository
@Validated
class Repository {

    fun insert(@Valid domain: Domain): Boolean {
        return true
    }
}
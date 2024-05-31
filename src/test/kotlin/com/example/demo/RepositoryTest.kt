package com.example.demo

import jakarta.validation.ConstraintViolationException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
class RepositoryTest {

    @Autowired
    lateinit var repository: Repository

    @Test
    fun testInsert() {
        val domain = Domain(email="email@example.com")
        assertEquals(
            true,
            repository.insert(domain)
        )
    }

    @Test
    fun testInsertWithInvalidEmail() {
        val domain = Domain(email="not_a_email")

        val exception = assertThrows(ConstraintViolationException::class.java) {
            repository.insert(domain)
        }
        assertEquals(1, exception.constraintViolations.size)
        assertEquals(
            "must be a well-formed email address",
            exception.constraintViolations.first().message
        )
    }
}
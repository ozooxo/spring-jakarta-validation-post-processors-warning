package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor

@Configuration
class AppConfig {

    @Bean
    fun validationPostProcessor(): MethodValidationPostProcessor {
        return MethodValidationPostProcessor()
    }
}
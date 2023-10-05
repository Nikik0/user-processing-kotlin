package com.nikik0.userProcessing.controllers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/health")
class UtilsController {
    @GetMapping()
    suspend fun getHealth() = HttpStatus.OK
}
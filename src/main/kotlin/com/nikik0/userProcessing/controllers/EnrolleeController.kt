package com.nikik0.userProcessing.controllers

import com.nikik0.userProcessing.entities.AdminEntity
import com.nikik0.userProcessing.entities.EnrolleeEntity
import com.nikik0.userProcessing.repositories.EnrolleeRepository
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/enrollee")
class EnrolleeController (
    private val enrolleeRepository: EnrolleeRepository
        ){
    @PostMapping("/create")
    suspend fun create(@RequestBody enrolleeEntity: EnrolleeEntity) =
        enrolleeRepository.save(enrolleeEntity) //todo checks and stuff

    @PostMapping("/delete/{id}")
    suspend fun delete(@PathVariable id: Long) =
        enrolleeRepository.deleteById(id)

    @GetMapping("/get/{id}")
    suspend fun getSingle(@PathVariable id: Long) =
        enrolleeRepository.findById(id)

    @GetMapping("/get/all")
    suspend fun getAll() =
        enrolleeRepository.findAll()

    @PostMapping("/update")
    suspend fun update(@RequestBody enrolleeEntity: EnrolleeEntity) =
        enrolleeRepository.save(enrolleeEntity)
}
package com.nikik0.userProcessing.controllers

import com.nikik0.userProcessing.entities.AdminEntity
import com.nikik0.userProcessing.entities.EnrolleeEntity
import com.nikik0.userProcessing.repositories.EnrolleeRepository
import com.nikik0.userProcessing.services.EnrolleeService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/enrollee")
class EnrolleeController (
    private val enrolleeService: EnrolleeService
        ){
    @PostMapping("/create")
    suspend fun create(@RequestBody enrolleeEntity: EnrolleeEntity, @RequestHeader("Authorization") auth: String) =
        enrolleeService.create(enrolleeEntity, auth)
//        enrolleeRepository.save(enrolleeEntity) //todo checks and stuff

    @PostMapping("/delete/{id}")
    suspend fun delete(@PathVariable id: Long, @RequestHeader("Authorization") auth: String) =
        enrolleeService.delete(id, auth)

    @GetMapping("/get/{id}")
    suspend fun getSingle(@PathVariable id: Long, @RequestHeader("Authorization") auth: String) =
        enrolleeService.getSingle(id, auth)

    @GetMapping("/get/all")
    suspend fun getAll(@RequestHeader("Authorization") auth: String) =
        enrolleeService.getAll(auth)

    @PostMapping("/update")
    suspend fun update(@RequestBody enrolleeEntity: EnrolleeEntity, @RequestHeader("Authorization") auth: String) =
        enrolleeService.update(enrolleeEntity, auth)
}
package com.nikik0.userProcessing.controllers

import com.nikik0.userProcessing.entities.AdminEntity
import com.nikik0.userProcessing.repositories.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/admin")
class AdminController (
    private val adminRepository: AdminRepository
        ){
    @PostMapping("/create")
    suspend fun create(@RequestBody adminEntity: AdminEntity) =
        adminRepository.save(adminEntity) //todo checks and stuff

    @PostMapping("/delete/{id}")
    suspend fun delete(@PathVariable id: Long) =
        adminRepository.deleteById(id)

    @GetMapping("/get/{id}")
    suspend fun getSingle(@PathVariable id: Long) =
        adminRepository.findById(id)

    @GetMapping("/get/all")
    suspend fun getAll() =
        adminRepository.findAll()

    @PostMapping("/update")
    suspend fun update(@RequestBody adminEntity: AdminEntity) =
        adminRepository.save(adminEntity)
}
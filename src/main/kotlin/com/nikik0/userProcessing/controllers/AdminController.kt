package com.nikik0.userProcessing.controllers

import com.nikik0.userProcessing.entities.AdminEntity
import com.nikik0.userProcessing.repositories.*
import com.nikik0.userProcessing.services.AdminService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/admin")
class AdminController (
    private val adminService: AdminService
        ){
    @PostMapping("/create")
    suspend fun create(@RequestBody adminEntity: AdminEntity, @RequestHeader("Authorization") auth: String) =
        adminService.create(adminEntity, auth)
        //adminRepository.save(adminEntity) //todo checks and stuff

    @PostMapping("/delete/{id}")
    suspend fun delete(@PathVariable id: Long, @RequestHeader("Authorization") auth: String) =
        adminService.delete(id, auth)

    @GetMapping("/get/{id}")
    suspend fun getSingle(@PathVariable id: Long, @RequestHeader("Authorization") auth: String) =
        adminService.getSingle(id, auth)

    @GetMapping("/get/all")
    suspend fun getAll(@RequestHeader("Authorization") auth: String) =
        adminService.getAll(auth)

    @PostMapping("/update")
    suspend fun update(@RequestBody adminEntity: AdminEntity, @RequestHeader("Authorization") auth: String) =
        adminService.update(adminEntity, auth)
}
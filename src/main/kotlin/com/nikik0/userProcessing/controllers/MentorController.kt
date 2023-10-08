package com.nikik0.userProcessing.controllers

import com.nikik0.userProcessing.entities.EnrolleeEntity
import com.nikik0.userProcessing.entities.MentorEntity
import com.nikik0.userProcessing.repositories.MentorRepository
import com.nikik0.userProcessing.services.MentorService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/mentor")
class MentorController(
    private val mentorService: MentorService
) {
    @PostMapping("/create")
    suspend fun create(@RequestBody mentorEntity: MentorEntity, @RequestHeader("Authorization") auth: String) =
        mentorService.create(mentorEntity, auth)

    @PostMapping("/delete/{id}")
    suspend fun delete(@PathVariable id: Long, @RequestHeader("Authorization") auth: String) =
        mentorService.delete(id, auth)

    @GetMapping("/get/{id}")
    suspend fun getSingle(@PathVariable id: Long, @RequestHeader("Authorization") auth: String) =
        mentorService.getSingle(id, auth)

    @GetMapping("/get/all")
    suspend fun getAll(@RequestHeader("Authorization") auth: String) =
        mentorService.getAll(auth)

    @PostMapping("/update")
    suspend fun update(@RequestBody mentorEntity: MentorEntity, @RequestHeader("Authorization") auth: String) =
        mentorService.update(mentorEntity, auth)
}
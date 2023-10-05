package com.nikik0.userProcessing.controllers

import com.nikik0.userProcessing.entities.EnrolleeEntity
import com.nikik0.userProcessing.entities.MentorEntity
import com.nikik0.userProcessing.repositories.MentorRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/mentor")
class MentorController(
    private val mentorRepository: MentorRepository
) {
    @PostMapping("/create")
    suspend fun create(@RequestBody mentorEntity: MentorEntity) =
        mentorRepository.save(mentorEntity) //todo checks and stuff

    @PostMapping("/delete/{id}")
    suspend fun delete(@PathVariable id: Long) =
        mentorRepository.deleteById(id)

    @GetMapping("/get/{id}")
    suspend fun getSingle(@PathVariable id: Long) =
        mentorRepository.findById(id)

    @GetMapping("/get/all")
    suspend fun getAll() =
        mentorRepository.findAll()

    @PostMapping("/update")
    suspend fun update(@RequestBody mentorEntity: MentorEntity) =
        mentorRepository.save(mentorEntity)
}
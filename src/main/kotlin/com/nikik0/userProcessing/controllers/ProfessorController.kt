package com.nikik0.userProcessing.controllers

import com.nikik0.userProcessing.entities.MentorEntity
import com.nikik0.userProcessing.entities.ProfessorEntity
import com.nikik0.userProcessing.repositories.MentorRepository
import com.nikik0.userProcessing.repositories.ProfessorRepository
import com.nikik0.userProcessing.services.ProfessorService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/professor")
class ProfessorController (
    private val professorService: ProfessorService
) {
    @PostMapping("/create")
    suspend fun create(@RequestBody professorEntity: ProfessorEntity, @RequestHeader("Authorization") auth: String) =
        professorService.create(professorEntity, auth)

    @PostMapping("/delete/{id}")
    suspend fun delete(@PathVariable id: Long, @RequestHeader("Authorization") auth: String) =
        professorService.delete(id, auth)

    @GetMapping("/get/{id}")
    suspend fun getSingle(@PathVariable id: Long, @RequestHeader("Authorization") auth: String) =
        professorService.getSingle(id, auth)

    @GetMapping("/get/all")
    suspend fun getAll(@RequestHeader("Authorization") auth: String) =
        professorService.getAll(auth)

    @PostMapping("/update")
    suspend fun update(@RequestBody professorEntity: ProfessorEntity, @RequestHeader("Authorization") auth: String) =
        professorService.update(professorEntity, auth)
}
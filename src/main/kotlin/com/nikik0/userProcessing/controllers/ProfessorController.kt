package com.nikik0.userProcessing.controllers

import com.nikik0.userProcessing.entities.MentorEntity
import com.nikik0.userProcessing.entities.ProfessorEntity
import com.nikik0.userProcessing.repositories.MentorRepository
import com.nikik0.userProcessing.repositories.ProfessorRepository
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/professor")
class ProfessorController (
    private val professorRepository: ProfessorRepository
) {
    @PostMapping("/create")
    suspend fun create(@RequestBody professorEntity: ProfessorEntity) =
        professorRepository.save(professorEntity) //todo checks and stuff

    @PostMapping("/delete/{id}")
    suspend fun delete(@PathVariable id: Long) =
        professorRepository.deleteById(id)

    @GetMapping("/get/{id}")
    suspend fun getSingle(@PathVariable id: Long) =
        professorRepository.findById(id)

    @GetMapping("/get/all")
    suspend fun getAll() =
        professorRepository.findAll()

    @PostMapping("/update")
    suspend fun update(@RequestBody professorEntity: ProfessorEntity) =
        professorRepository.save(professorEntity)
}
package com.nikik0.userProcessing.controllers

import com.nikik0.userProcessing.entities.ProfessorEntity
import com.nikik0.userProcessing.entities.StudentEntity
import com.nikik0.userProcessing.repositories.ProfessorRepository
import com.nikik0.userProcessing.repositories.StudentRepository
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/student")
class StudentController (
    private val studentRepository: StudentRepository
) {
    @PostMapping("/create")
    suspend fun create(@RequestBody studentEntity: StudentEntity) =
        studentRepository.save(studentEntity) //todo checks and stuff

    @PostMapping("/delete/{id}")
    suspend fun delete(@PathVariable id: Long) =
        studentRepository.deleteById(id)

    @GetMapping("/get/{id}")
    suspend fun getSingle(@PathVariable id: Long) =
        studentRepository.findById(id)

    @GetMapping("/get/all")
    suspend fun getAll() =
        studentRepository.findAll()

    @PostMapping("/update")
    suspend fun update(@RequestBody studentEntity: StudentEntity) =
        studentRepository.save(studentEntity)
}
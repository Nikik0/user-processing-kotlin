package com.nikik0.userProcessing.controllers

import com.nikik0.userProcessing.entities.ProfessorEntity
import com.nikik0.userProcessing.entities.StudentEntity
import com.nikik0.userProcessing.repositories.ProfessorRepository
import com.nikik0.userProcessing.repositories.StudentRepository
import com.nikik0.userProcessing.services.StudentService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/student")
class StudentController (
    private val studentService: StudentService
) {
    @PostMapping("/create")
    suspend fun create(@RequestBody studentEntity: StudentEntity, @RequestHeader("Authorization") auth: String) =
        studentService.create(studentEntity, auth) //todo checks and stuff

    @PostMapping("/delete/{id}")
    suspend fun delete(@PathVariable id: Long, @RequestHeader("Authorization") auth: String) =
        studentService.delete(id, auth)

    @GetMapping("/get/{id}")
    suspend fun getSingle(@PathVariable id: Long, @RequestHeader("Authorization") auth: String) =
        studentService.getSingle(id, auth)

    @GetMapping("/get/all")
    suspend fun getAll(@RequestHeader("Authorization") auth: String) =
        studentService.getAll(auth)

    @PostMapping("/update")
    suspend fun update(@RequestBody studentEntity: StudentEntity, @RequestHeader("Authorization") auth: String) =
        studentService.update(studentEntity, auth)
}
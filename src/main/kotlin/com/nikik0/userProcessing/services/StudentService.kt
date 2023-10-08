package com.nikik0.userProcessing.services

import com.nikik0.userProcessing.entities.ProfessorEntity
import com.nikik0.userProcessing.entities.StudentEntity
import com.nikik0.userProcessing.repositories.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(
    private val externalSecurityService: ExternalSecurityService,
    private val studentRepository: StudentRepository
) {
    suspend fun create(studentEntity: StudentEntity, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("professor", "mentor", "admin")))
            studentRepository.save(studentEntity)
        else null

    suspend fun delete(id: Long, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("admin")))
            studentRepository.deleteById(id)
        else null

    suspend fun getSingle(id: Long, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("enrollee", "student","professor", "mentor", "admin")))
            studentRepository.findById(id)
        else null

    suspend fun getAll(auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("enrollee", "student","professor", "mentor", "admin")))
            studentRepository.findAll()
        else null

    suspend fun update(studentEntity: StudentEntity, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("mentor", "admin")))
            studentRepository.save(studentEntity)
        else null
}
package com.nikik0.userProcessing.services

import com.nikik0.userProcessing.entities.MentorEntity
import com.nikik0.userProcessing.entities.ProfessorEntity
import com.nikik0.userProcessing.repositories.ProfessorRepository
import org.springframework.stereotype.Service

@Service
class ProfessorService(
    private val professorRepository: ProfessorRepository,
    private val externalSecurityService: ExternalSecurityService
) {
    suspend fun create(professorEntity: ProfessorEntity, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("professor", "mentor", "admin")))
            professorRepository.save(professorEntity)
        else null

    suspend fun delete(id: Long, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("admin")))
            professorRepository.deleteById(id)
        else null

    suspend fun getSingle(id: Long, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("enrollee", "student","professor", "mentor", "admin")))
            professorRepository.findById(id)
        else null

    suspend fun getAll(auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("enrollee", "student","professor", "mentor", "admin")))
            professorRepository.findAll()
        else null

    suspend fun update(professorEntity: ProfessorEntity, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("mentor", "admin")))
            professorRepository.save(professorEntity)
        else null
}
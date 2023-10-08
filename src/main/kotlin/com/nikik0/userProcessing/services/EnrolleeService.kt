package com.nikik0.userProcessing.services

import com.nikik0.userProcessing.entities.AdminEntity
import com.nikik0.userProcessing.entities.EnrolleeEntity
import com.nikik0.userProcessing.repositories.EnrolleeRepository
import org.springframework.stereotype.Service

@Service
class EnrolleeService(
    private val enrolleeRepository: EnrolleeRepository,
    private val externalSecurityService: ExternalSecurityService
) {

    suspend fun create(enrolleeEntity: EnrolleeEntity, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("enrollee", "student","professor", "mentor", "admin")))
            enrolleeRepository.save(enrolleeEntity)
        else null

    suspend fun delete(id: Long, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("professor", "mentor", "admin")))
            enrolleeRepository.deleteById(id)
        else null

    suspend fun getSingle(id: Long, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("enrollee", "student","professor", "mentor", "admin")))
            enrolleeRepository.findById(id)
        else null

    suspend fun getAll(auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("enrollee", "student","professor", "mentor", "admin")))
            enrolleeRepository.findAll()
        else null

    suspend fun update(enrolleeEntity: EnrolleeEntity, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("professor", "mentor", "admin")))
            enrolleeRepository.save(enrolleeEntity)
        else null
}
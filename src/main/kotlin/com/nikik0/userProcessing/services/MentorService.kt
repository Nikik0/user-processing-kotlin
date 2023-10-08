package com.nikik0.userProcessing.services

import com.nikik0.userProcessing.entities.EnrolleeEntity
import com.nikik0.userProcessing.entities.MentorEntity
import com.nikik0.userProcessing.repositories.MentorRepository
import org.springframework.stereotype.Service

@Service
class MentorService(
    private val externalSecurityService: ExternalSecurityService,
    private val mentorRepository: MentorRepository
) {
    suspend fun create(mentorEntity: MentorEntity, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("professor", "mentor", "admin")))
            mentorRepository.save(mentorEntity)
        else null

    suspend fun delete(id: Long, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("admin")))
            mentorRepository.deleteById(id)
        else null

    suspend fun getSingle(id: Long, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("enrollee", "student","professor", "mentor", "admin")))
            mentorRepository.findById(id)
        else null

    suspend fun getAll(auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("enrollee", "student","professor", "mentor", "admin")))
            mentorRepository.findAll()
        else null

    suspend fun update(mentorEntity: MentorEntity, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("mentor", "admin")))
            mentorRepository.save(mentorEntity)
        else null
}
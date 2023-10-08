package com.nikik0.userProcessing.services

import com.nikik0.userProcessing.entities.AdminEntity
import com.nikik0.userProcessing.repositories.AdminRepository
import org.springframework.stereotype.Service

@Service
class AdminService(
    private val adminRepository: AdminRepository,
    private val externalSecurityService: ExternalSecurityService
) {
    suspend fun create(adminEntity: AdminEntity, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("admin")))
            adminRepository.save(adminEntity)
        else null

    suspend fun delete(id: Long, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("admin")))
            adminRepository.deleteById(id)
        else null

    suspend fun getSingle(id: Long, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("admin")))
            adminRepository.findById(id)
        else null

    suspend fun getAll(auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("admin")))
            adminRepository.findAll()
        else null

    suspend fun update(adminEntity: AdminEntity, auth: String) =
        if (externalSecurityService.callToCheckCred(auth, listOf("admin")))
            adminRepository.save(adminEntity)
        else null
}
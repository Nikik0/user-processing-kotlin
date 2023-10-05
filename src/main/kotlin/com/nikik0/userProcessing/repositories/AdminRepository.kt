package com.nikik0.userProcessing.repositories

import com.nikik0.userProcessing.entities.AdminEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AdminRepository: CoroutineCrudRepository<AdminEntity, Long> {
}
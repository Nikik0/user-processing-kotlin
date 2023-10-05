package com.nikik0.userProcessing.repositories

import com.nikik0.userProcessing.entities.EnrolleeEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EnrolleeRepository: CoroutineCrudRepository<EnrolleeEntity, Long> {
}
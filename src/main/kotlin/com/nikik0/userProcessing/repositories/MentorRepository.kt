package com.nikik0.userProcessing.repositories

import com.nikik0.userProcessing.entities.MentorEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MentorRepository: CoroutineCrudRepository<MentorEntity, Long> {
}
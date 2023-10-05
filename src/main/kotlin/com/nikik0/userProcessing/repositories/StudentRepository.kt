package com.nikik0.userProcessing.repositories

import com.nikik0.userProcessing.entities.StudentEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository: CoroutineCrudRepository<StudentEntity, Long> {
}
package com.nikik0.userProcessing.repositories

import com.nikik0.userProcessing.entities.ProfessorEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfessorRepository: CoroutineCrudRepository<ProfessorEntity, Long>{
}
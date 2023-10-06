package com.nikik0.userProcessing.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("professor")
data class ProfessorEntity(
    @Id
    val id: Long,
    val name: String,
    val surname: String,
    @Column("info")
    val additionalInfo: String,
    val age: Int,
    val role: UserRole,
    val subject: String //todo must be refactored to subjectList
)

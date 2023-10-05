package com.nikik0.userProcessing.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("student")
data class StudentEntity(
    @Id
    val id: Long,
    val name: String,
    val surname: String,
    val additionalInfo: String,
    val age: Int,
    val role: UserRole,
    val course: Int,
    @Column("group_id")
    val groupId: Long
)

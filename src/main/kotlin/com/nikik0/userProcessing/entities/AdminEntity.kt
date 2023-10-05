package com.nikik0.userProcessing.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("admin")
data class AdminEntity(
    @Id
    val id: Long,
    val name: String,
    val surname: String,
    @Column("info")
    val additionalInfo: String,
    val age: Int,
    val role: UserRole
)

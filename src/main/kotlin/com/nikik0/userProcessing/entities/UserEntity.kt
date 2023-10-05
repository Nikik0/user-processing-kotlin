package com.nikik0.userProcessing.entities

data class UserEntity(
    //todo отдельный сервис (в апишке возможно)
    val id: Long,
    val login: String,
    val password: String,
    val role: UserRole,
    val internalEntityId: Long
)

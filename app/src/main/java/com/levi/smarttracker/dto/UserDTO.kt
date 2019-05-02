package com.levi.smarttracker.dto

import com.levi.smarttracker.enumerated.PerfilEnum

data class UserDTO(
        val username: String,
        val password: String,
        val email: String,
        val perfil : PerfilEnum? = null,
        val id: Int? = null
)
package com.onlineshop.onlineshopkmmlibrary.networking.login


@kotlinx.serialization.Serializable
class SignUpRequest(
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val password: String?,
    val role: String?
)

package com.onlineshop.onlineshopkmmlibrary.networking.login


@kotlinx.serialization.Serializable
class SignInRequest(
    val email: String?,
    val password: String?
)

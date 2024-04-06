package com.onlineshop.onlineshopkmmlibrary.networking.model

import kotlinx.serialization.Serializable

@Serializable
data class Token (
    val accessToken: String,
    val refreshToken: String
)
package com.onlineshop.onlineshopkmmlibrary.networking.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
data class Token (
    @JsonNames("access_token")
    val accessToken: String,
    @JsonNames("refresh_token")
    val refreshToken: String
)
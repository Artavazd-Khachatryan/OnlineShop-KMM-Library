package com.onlineshop.onlineshopkmmlibrary.networking.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class Token(
    @JsonNames("access_token")
    val accessToken: String,
    @JsonNames("refresh_token")
    val refreshToken: String
)
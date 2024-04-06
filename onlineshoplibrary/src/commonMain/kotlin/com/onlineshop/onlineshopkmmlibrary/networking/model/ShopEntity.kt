package com.onlineshop.onlineshopkmmlibrary.networking.model

import kotlinx.serialization.Serializable

@Serializable
data class ShopEntity(
    val id: Long ,
    val name: String? = null,
    val description: String? = null,
)
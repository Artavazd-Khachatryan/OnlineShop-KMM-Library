package com.onlineshop.onlineshopkmmlibrary.networking.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductEntity(
    val id: Long,
    val shopId: Long,
    val title: String? = null,
    val description: String? = null,
    val price: Double = 0.0,
    val category: String? = null
)
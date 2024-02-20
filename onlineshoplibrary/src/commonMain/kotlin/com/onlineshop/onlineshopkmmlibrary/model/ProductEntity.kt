package com.onlineshop.onlineshopkmmlibrary.model

data class ProductEntity(
    val id: Long,
    val shop: Long,
    val title: String? = null,
    val description: String? = null,
    val price: Double = 0.0,
    val category: String? = null,
)
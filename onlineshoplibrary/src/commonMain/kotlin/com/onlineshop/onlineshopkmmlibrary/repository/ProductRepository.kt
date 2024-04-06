package com.onlineshop.onlineshopkmmlibrary.repository

import com.onlineshop.onlineshopkmmlibrary.networking.model.ProductEntity

interface ProductRepository {

    fun getAllProducts(): List<ProductEntity>

    fun getProducts(shopId: Long): List<ProductEntity>
}
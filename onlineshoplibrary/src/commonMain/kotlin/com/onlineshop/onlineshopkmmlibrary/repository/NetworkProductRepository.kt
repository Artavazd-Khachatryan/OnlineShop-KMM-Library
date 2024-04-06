package com.onlineshop.onlineshopkmmlibrary.repository

import com.onlineshop.onlineshopkmmlibrary.datasource.TestDataSource
import com.onlineshop.onlineshopkmmlibrary.networking.model.ProductEntity

class NetworkProductRepository(private val dataSource: TestDataSource): ProductRepository {

    override fun getAllProducts(): List<ProductEntity> = dataSource.productList

    override fun getProducts(shopId: Long): List<ProductEntity> = getAllProducts().filter { it.shop == shopId }
}
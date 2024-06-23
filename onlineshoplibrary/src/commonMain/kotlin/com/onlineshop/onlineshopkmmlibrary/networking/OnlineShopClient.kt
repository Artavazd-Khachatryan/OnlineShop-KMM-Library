package com.onlineshop.onlineshopkmmlibrary.networking

import com.onlineshop.onlineshopkmmlibrary.networking.model.ShopEntity
import com.onlineshop.onlineshopkmmlibrary.networking.model.CreateShopRequestModel
import com.onlineshop.onlineshopkmmlibrary.networking.model.ProductEntity
import com.onlineshop.onlineshopkmmlibrary.networking.model.CreateProductRequestModel

interface OnlineShopClient {

    suspend fun testCall(): String

    suspend fun getShops(): List<ShopEntity>

    suspend fun getShopWithId(id: Long): ShopEntity

    suspend fun createShop(createShopRequestModel: CreateShopRequestModel): ShopEntity

    suspend fun deleteWithShopId(id: Long)

    suspend fun addProduct(createProductRequestModel: CreateProductRequestModel): ProductEntity

    suspend fun getProducts(): List<ProductEntity>

    suspend fun getProductById(id: Long): ProductEntity

    suspend fun deleteWithProductId(id: Long)
}
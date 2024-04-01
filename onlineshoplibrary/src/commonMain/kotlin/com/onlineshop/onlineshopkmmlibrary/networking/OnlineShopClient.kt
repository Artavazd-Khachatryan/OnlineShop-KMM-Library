package com.onlineshop.onlineshopkmmlibrary.networking

import com.onlineshop.onlineshopkmmlibrary.model.ShopEntity
import com.onlineshop.onlineshopkmmlibrary.model.ShopRequestModel

interface OnlineShopClient {

    suspend fun testCall(): String

    suspend fun getShops(): List<ShopEntity>

    suspend fun getShopWithId(id: Long): ShopEntity

    suspend fun createShop(shopRequestModel: ShopRequestModel): ShopEntity

    suspend fun deleteWithShopId(id: Long)

}
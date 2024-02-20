package com.onlineshop.onlineshopkmmlibrary.repository

import com.onlineshop.onlineshopkmmlibrary.datasource.TestDataSource
import com.onlineshop.onlineshopkmmlibrary.model.ShopEntity

class NetworkShopRepository(private val testDataSource: TestDataSource): ShopRepository {

    override fun getAllShops(): List<ShopEntity> = testDataSource.shopList

}
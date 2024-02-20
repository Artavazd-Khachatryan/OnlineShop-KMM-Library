package com.onlineshop.onlineshopkmmlibrary.repository

import com.onlineshop.onlineshopkmmlibrary.model.ShopEntity

interface ShopRepository {
    fun getAllShops(): List<ShopEntity>
}
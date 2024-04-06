package com.onlineshop.onlineshopkmmlibrary.repository

import com.onlineshop.onlineshopkmmlibrary.networking.model.ShopEntity

interface ShopRepository {
    fun getAllShops(): List<ShopEntity>
}
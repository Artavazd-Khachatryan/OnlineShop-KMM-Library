package com.onlineshop.onlineshopkmmlibrary

import com.onlineshop.onlineshopkmmlibrary.datasource.TestDataSource
import com.onlineshop.onlineshopkmmlibrary.repository.NetworkProductRepository
import com.onlineshop.onlineshopkmmlibrary.repository.NetworkShopRepository
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CommonGreetingTest {

    @Test
    fun testExample() {
        val networkShopRepository = NetworkShopRepository(TestDataSource())
        val networkProductRepository = NetworkProductRepository(TestDataSource())

        val testDataSource = TestDataSource()

        assertEquals(testDataSource.shopList, networkShopRepository.getAllShops())
        assertEquals(testDataSource.productList, networkProductRepository.getAllProducts())
    }
}
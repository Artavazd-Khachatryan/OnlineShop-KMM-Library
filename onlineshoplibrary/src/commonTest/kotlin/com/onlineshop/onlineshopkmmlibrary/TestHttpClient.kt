package com.onlineshop.onlineshopkmmlibrary

import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.networking
import com.onlineshop.onlineshopkmmlibrary.model.ShopRequestModel
import com.onlineshop.onlineshopkmmlibrary.networking.OnlineShopClient
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.test.runTest
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class TestHttpClient: KoinTest {

    @BeforeTest
    fun setup() = runTest {
        startKoin {
            modules(networking())
        }
    }

    private val client: HttpClient by inject()
    private val onlineShopClient: OnlineShopClient by inject()

    @Test
    fun testClient() = runTest {
        //val response: HttpResponse = client.get("https://ktor.io/")
        val response: HttpResponse = client.get("http://localhost:8080/api/v1/shop") {
            headers {
                append("Content-Type", "application/json")
                append("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huLmRvZUBleGFtcGxlLmNvbSIsImlhdCI6MTcxMTcxMTAxNSwiZXhwIjoxNzExNzk3NDE1fQ.7bTV7_-qqyPtR9rETxfqZGQWlrzC4zieEYLK-oFxYkk")
            }
        }
        assertEquals(200, response.status.value)
    }

    @Test
    fun testingShops() = runTest {
        val shops =  onlineShopClient.getShops()
        assertTrue(shops.isNotEmpty())
    }

    @Test
    fun testingShop() = runTest {
        val shop = onlineShopClient.createShop(ShopRequestModel(name = "Kia","Car"))
        assertTrue(shop.id != 0L)
    }

    @Test
    fun testShopWithId() = runTest {
        val shopWithId = onlineShopClient.getShopWithId(1)
        assertTrue(shopWithId.id == 1L)
    }

    @Test
    fun testDeleteWithId() = runTest {
        val response = client.delete("http://localhost:8080/" + "api/v1/shop/$9") {
            headers{
                append("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huLmRvZUBleGFtcGxlLmNvbSIsImlhdCI6MTcxMTcxMTAxNSwiZXhwIjoxNzExNzk3NDE1fQ.7bTV7_-qqyPtR9rETxfqZGQWlrzC4zieEYLK-oFxYkk")
            }
        }
        assertEquals(204,response.status.value)
    }
}
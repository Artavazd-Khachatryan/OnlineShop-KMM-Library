package com.onlineshop.onlineshopkmmlibrary.apiTests

import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.networking
import com.onlineshop.onlineshopkmmlibrary.networking.model.CreateShopRequestModel
import com.onlineshop.onlineshopkmmlibrary.networking.model.CreateProductRequestModel
import com.onlineshop.onlineshopkmmlibrary.networking.OnlineShopClient
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.test.runTest
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.*


class TestHttpClient : KoinTest {

    @BeforeTest
    fun setup() = runTest {
        startKoin {
            modules(networking())
        }
    }

    @AfterTest
    fun clean() {
        stopKoin()
    }

    private val client: HttpClient by inject()
    private val onlineShopClient: OnlineShopClient by inject()

    @Test
    fun testClient() = runTest {
        //val response: HttpResponse = client.get("https://ktor.io/")
        val response: HttpResponse = client.get("http://localhost:8080/api/v1/shop")
        assertEquals(200, response.status.value)
    }

    @Test
    fun testingShops() = runTest {
        val shops = onlineShopClient.getShops()
        assertTrue(shops.isNotEmpty())
    }

    @Test
    fun testingShop() = runTest {
        val shop = onlineShopClient.createShop(CreateShopRequestModel(name = "Kia", "Car"))
        assertTrue(shop.id != 0L)
    }

    @Test
    fun testShopWithId() = runTest {
        val shopWithId = onlineShopClient.getShopWithId(1)
        assertTrue(shopWithId.id == 1L)
    }

    @Test
    fun testDeleteShopWithId() = runTest {
        val response = client.delete("http://localhost:8080/" + "api/v1/shop/9") {
        }
        assertEquals(204, response.status.value)
    }

    @Test
    fun testAddProduct() = runTest {
        val product = onlineShopClient.addProduct(
            CreateProductRequestModel(
                shopId = 5L,
                title = "test",
                description = "test",
                price = 1.1,
                category = "test"
            )
        )
        assertTrue(product.id != null)
    }

    @Test
    fun testGetProducts() = runTest {
        val products = onlineShopClient.getProducts()
        assertTrue(products.isNotEmpty())
    }

    @Test
    fun testGetProductWithId() = runTest {
        val productWithId = onlineShopClient.getProductById(5L)
        assertTrue(productWithId.id == 5L)
    }

    @Test
    fun testDeleteProductWithId() = runTest {
        val response = client.delete("http://localhost:8080/" + "api/v1/product/4") {
        }
        assertEquals(204, response.status.value)
    }
}
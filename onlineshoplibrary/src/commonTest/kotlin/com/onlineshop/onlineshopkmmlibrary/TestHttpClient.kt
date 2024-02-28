package com.onlineshop.onlineshopkmmlibrary

import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.networking
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

class TestHttpClient: KoinTest {

    @BeforeTest
    fun setup() = runTest {
        startKoin {
            modules(networking())
        }
    }

    private val client: HttpClient by inject()

    @Test
    fun testClient() = runTest {
        //val response: HttpResponse = client.get("https://ktor.io/")
        val response: HttpResponse = client.get("http://localhost:8080/api/v1/shop")
        assertEquals(200, response.status.value)
    }
}
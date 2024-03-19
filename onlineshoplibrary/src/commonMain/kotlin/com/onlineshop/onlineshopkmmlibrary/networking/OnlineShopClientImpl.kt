package com.onlineshop.onlineshopkmmlibrary.networking

import io.ktor.client.*
import io.ktor.client.request.*

class OnlineShopClientImpl(private val httpClient: HttpClient): OnlineShopClient {

    private val baseUrl = "http://localhost:8080/"

    override suspend fun testCall(): String {
        return httpClient.get(baseUrl + "api/v1/shop") {
            headers {
                append("Content-Type", "application/json")
                append("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huLmRvZUBleGFtcGxlNy5jb20iLCJpYXQiOjE3MTA4NzY1OTIsImV4cCI6MTcxMDk2Mjk5Mn0.SXimS6ON1tTYj_RXwA-ab2euXaAqtvl6P8f0G2qyWKY")
            }
        }.toString()
    }
}
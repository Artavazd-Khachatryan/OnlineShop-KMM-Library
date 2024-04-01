package com.onlineshop.onlineshopkmmlibrary.networking

import com.onlineshop.onlineshopkmmlibrary.model.ShopEntity
import com.onlineshop.onlineshopkmmlibrary.model.ShopRequestModel
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.http.ContentType
import io.ktor.http.contentType

class OnlineShopClientImpl(private val httpClient: HttpClient): OnlineShopClient {

    private val baseUrl = "http://localhost:8080/"

    override suspend fun testCall(): String {
        return httpClient.get(baseUrl + "api/v1/shop") {
            headers {
                append("Content-Type", "application/json")
                append("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huLmRvZUBleGFtcGxlLmNvbSIsImlhdCI6MTcxMTcxMTAxNSwiZXhwIjoxNzExNzk3NDE1fQ.7bTV7_-qqyPtR9rETxfqZGQWlrzC4zieEYLK-oFxYkk")
            }
        }.toString()
    }

    override suspend fun getShops(): List<ShopEntity> {
        return httpClient.get(baseUrl + "api/v1/shop") {
            headers {
                append("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huLmRvZUBleGFtcGxlLmNvbSIsImlhdCI6MTcxMTcxMTAxNSwiZXhwIjoxNzExNzk3NDE1fQ.7bTV7_-qqyPtR9rETxfqZGQWlrzC4zieEYLK-oFxYkk")
            }
        }.body<List<ShopEntity>>()
    }

    override suspend fun getShopWithId(id: Long): ShopEntity {
        return httpClient.get(baseUrl + "api/v1/shop/$id") {
            headers {
                append("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huLmRvZUBleGFtcGxlLmNvbSIsImlhdCI6MTcxMTcxMTAxNSwiZXhwIjoxNzExNzk3NDE1fQ.7bTV7_-qqyPtR9rETxfqZGQWlrzC4zieEYLK-oFxYkk")
            }
        }.body<ShopEntity>()
    }

    override suspend fun createShop(shopRequestModel: ShopRequestModel): ShopEntity {
        return httpClient.post(baseUrl + "api/v1/shop") {
            contentType(ContentType.Application.Json)
            setBody(shopRequestModel)
            headers {
                append("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huLmRvZUBleGFtcGxlLmNvbSIsImlhdCI6MTcxMTcxMTAxNSwiZXhwIjoxNzExNzk3NDE1fQ.7bTV7_-qqyPtR9rETxfqZGQWlrzC4zieEYLK-oFxYkk")
            }
        }.body<ShopEntity>()
    }

    override suspend fun deleteWithShopId(id: Long) {
        httpClient.delete(baseUrl + "api/v1/shop/$id") {
            headers{
                append("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huLmRvZUBleGFtcGxlLmNvbSIsImlhdCI6MTcxMTcxMTAxNSwiZXhwIjoxNzExNzk3NDE1fQ.7bTV7_-qqyPtR9rETxfqZGQWlrzC4zieEYLK-oFxYkk")
            }
        }
    }
}
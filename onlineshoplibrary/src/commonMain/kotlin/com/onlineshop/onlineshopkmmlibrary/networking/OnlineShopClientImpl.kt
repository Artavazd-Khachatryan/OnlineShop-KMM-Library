package com.onlineshop.onlineshopkmmlibrary.networking

import com.onlineshop.onlineshopkmmlibrary.networking.model.ShopEntity
import com.onlineshop.onlineshopkmmlibrary.networking.model.CreateShopRequestModel
import com.onlineshop.onlineshopkmmlibrary.networking.model.ProductEntity
import com.onlineshop.onlineshopkmmlibrary.networking.model.CreateProductRequestModel
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
            }
        }.toString()
    }

    override suspend fun getShops(): List<ShopEntity> {
        return httpClient.get(baseUrl + "api/v1/shop") {
        }.body<List<ShopEntity>>()
    }

    override suspend fun getShopWithId(id: Long): ShopEntity {
        return httpClient.get(baseUrl + "api/v1/shop/$id") {
        }.body<ShopEntity>()
    }

    override suspend fun createShop(createShopRequestModel: CreateShopRequestModel): ShopEntity {
        return httpClient.post(baseUrl + "api/v1/shop") {
            contentType(ContentType.Application.Json)
            setBody(createShopRequestModel)
        }.body<ShopEntity>()
    }

    override suspend fun deleteWithShopId(id: Long) {
        httpClient.delete(baseUrl + "api/v1/shop/$id") {
        }
    }

    override suspend fun addProduct(createProductRequestModel: CreateProductRequestModel): ProductEntity {
        return httpClient.post(baseUrl + "api/v1/product") {
            contentType(ContentType.Application.Json)
            setBody(createProductRequestModel)
        }.body<ProductEntity>()
    }

    override suspend fun getProducts(): List<ProductEntity> {
        return httpClient.get(baseUrl + "api/v1/product") {
            contentType(ContentType.Application.Json)
        }.body<List<ProductEntity>>()
    }

    override suspend fun getProductById(id: Long): ProductEntity {
        return httpClient.get(baseUrl + "api/v1/product/$id") {
        }.body<ProductEntity>()
    }

    override suspend fun deleteWithProductId(id: Long) {
        httpClient.delete(baseUrl + "api/v1/product/$id") {
        }
    }
}
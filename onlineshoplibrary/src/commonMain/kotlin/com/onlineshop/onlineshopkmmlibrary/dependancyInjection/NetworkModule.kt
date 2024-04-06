package com.onlineshop.onlineshopkmmlibrary.dependancyInjection

import com.onlineshop.onlineshopkmmlibrary.httpClient
import com.onlineshop.onlineshopkmmlibrary.networking.OnlineShopClient
import com.onlineshop.onlineshopkmmlibrary.networking.OnlineShopClientImpl
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import org.koin.dsl.module

fun networking() = module {

    factory(Qualifiers.BaseUrl) { "localhost:8080/api/v1/" }

    factory {
        httpClient {
            install(Logging)
            install(ContentNegotiation) {
                json()
            }
        }
    }

    factory<OnlineShopClient> { OnlineShopClientImpl(get()) }
}
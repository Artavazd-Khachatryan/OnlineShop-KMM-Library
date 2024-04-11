package com.onlineshop.onlineshopkmmlibrary.dependancyInjection

import com.onlineshop.onlineshopkmmlibrary.httpClient
import com.onlineshop.onlineshopkmmlibrary.networking.OnlineShopClient
import com.onlineshop.onlineshopkmmlibrary.networking.OnlineShopClientImpl
import com.onlineshop.onlineshopkmmlibrary.networking.login.LoginApi
import com.onlineshop.onlineshopkmmlibrary.repository.TokenRepository
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val BASE_URL = "http://localhost:8080/api/v1/"

val LOGIN_CLIENT = named("Authentication")

fun networking() = module {

    factory { LoginApi(get(LOGIN_CLIENT)) }

    factory {
        httpClient {
            install(Auth) {
                bearer {
                    loadTokens {
                        val tokenRepository: TokenRepository = get()
                        val token = tokenRepository.getToken() ?: return@loadTokens null
                        BearerTokens(token.accessToken, token.refreshToken)
                    }
                }
            }
            install(Logging)
            install(ContentNegotiation) {
                json()
            }
            defaultRequest {
                url(BASE_URL)
            }
        }
    }

    factory(qualifier = LOGIN_CLIENT) {
        httpClient {
            install(ContentNegotiation) {
                json()
            }
            defaultRequest {
                url(BASE_URL)
            }
        }
    }

    factory<OnlineShopClient> { OnlineShopClientImpl(get()) }
}
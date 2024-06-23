package com.onlineshop.onlineshopkmmlibrary.networking.login

import com.onlineshop.onlineshopkmmlibrary.networking.model.Token
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class LoginApi(private val client: HttpClient) {

    suspend fun signup(signUpRequest: SignUpRequest): Token {
        return client.post("auth/signup") {
            contentType(ContentType.Application.Json)
            setBody(signUpRequest)
        }.body<Token>()
    }

    suspend fun signin(signInRequest: SignInRequest): Token {
        return client.post("auth/signin") {
            contentType(ContentType.Application.Json)
            setBody(signInRequest)
        }.body<Token>()
    }
}
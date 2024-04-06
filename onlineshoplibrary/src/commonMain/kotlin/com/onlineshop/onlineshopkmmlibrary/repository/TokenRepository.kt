package com.onlineshop.onlineshopkmmlibrary.repository

import com.onlineshop.onlineshopkmmlibrary.networking.model.Token


interface TokenRepository {

    suspend fun saveToken(accessToken: String, refreshToken: String)

    suspend fun getToken(): Token

    suspend fun deleteToken()
}
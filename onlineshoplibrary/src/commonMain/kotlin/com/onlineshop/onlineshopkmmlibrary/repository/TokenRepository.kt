package com.onlineshop.onlineshopkmmlibrary.repository

import com.onlineshop.onlineshopkmmlibrary.networking.model.Token
import comonlineshopdatabase.TokenEntityQueries

class TokenRepository(
    private val tokenTable: TokenEntityQueries
) {

    suspend fun saveToken(accessToken: String, refreshToken: String) {
        tokenTable.insertToken(accessToken, refreshToken)
    }

    suspend fun getToken(): Token? {
        return tokenTable.getToken().executeAsOneOrNull()?.let {
            Token(it.accessToken, it.refreshToken)
        }
    }

    suspend fun deleteToken() {
        tokenTable.deleteToken()
    }
}
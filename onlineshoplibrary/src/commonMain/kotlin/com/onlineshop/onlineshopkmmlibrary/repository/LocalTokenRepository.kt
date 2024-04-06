package com.onlineshop.onlineshopkmmlibrary.repository

import com.onlineshop.onlineshopkmmlibrary.networking.model.Token
import comonlineshopdatabase.TokenEntityQueries

class LocalTokenRepository(
    private val tokenTable: TokenEntityQueries
) : TokenRepository {

    override suspend fun saveToken(accessToken: String, refreshToken: String) {
        tokenTable.insertToken(accessToken, refreshToken)
    }

    override suspend fun getToken(): Token {
        return tokenTable.getToken().executeAsOne().let {
            Token(it.accessToken, it.refreshToken)
        }
    }

    override suspend fun deleteToken() {
        tokenTable.deleteToken()
    }
}
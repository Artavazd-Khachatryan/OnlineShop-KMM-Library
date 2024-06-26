package com.onlineshop.onlineshopkmmlibrary.useCases

import com.onlineshop.onlineshopkmmlibrary.async.DispatcherProvider
import com.onlineshop.onlineshopkmmlibrary.networking.login.LoginApi
import com.onlineshop.onlineshopkmmlibrary.networking.login.SignInRequest
import com.onlineshop.onlineshopkmmlibrary.repository.TokenRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginUseCase(
    private val tokenRepository: TokenRepository,
    private val dispatcherProvider: DispatcherProvider,
    private val loginApi: LoginApi
) {

    var onSuccess: (() -> Unit)? = null
    var onFail: (() -> Unit)? = null

    fun execute(email: String, password: String) {
        CoroutineScope(dispatcherProvider.io).launch {
            val result = runCatching {
                loginApi.signin(SignInRequest(email, password))
            }
            if (result.isSuccess) {
                val token = result.getOrThrow()
                    tokenRepository.saveToken(token.accessToken, token.refreshToken)
                withContext(dispatcherProvider.main) {
                    onSuccess?.invoke()
                }
            } else {
                withContext(dispatcherProvider.main) {
                    onFail?.invoke()
                }
            }
        }
    }
}
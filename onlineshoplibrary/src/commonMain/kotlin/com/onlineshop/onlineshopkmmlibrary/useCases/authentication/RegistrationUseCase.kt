package com.onlineshop.onlineshopkmmlibrary.useCases.authentication

import com.onlineshop.onlineshopkmmlibrary.async.DispatcherProvider
import com.onlineshop.onlineshopkmmlibrary.networking.login.LoginApi
import com.onlineshop.onlineshopkmmlibrary.networking.login.SignUpRequest
import com.onlineshop.onlineshopkmmlibrary.networking.model.Token
import com.onlineshop.onlineshopkmmlibrary.repository.TokenRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegistrationUseCase(
    private val tokenRepository: TokenRepository,
    private val loginApi: LoginApi,
    private val dispatcherProvider: DispatcherProvider
) {

    var onSuccess: ((Token) -> Unit)? = null
    var onFail: (() -> Unit)? = null

    fun execute(
        firstName: String,
        lastName: String,
        email: String,
        password: String,
        role: String
    ) {
        CoroutineScope(dispatcherProvider.io).launch {
            val result = runCatching {
                loginApi.signup(SignUpRequest(firstName, lastName, email, password, role))
            }
            if (result.isSuccess) {
                val token = result.getOrThrow()
                tokenRepository.saveToken(token.accessToken, token.refreshToken)
                withContext(dispatcherProvider.main) {
                    onSuccess?.invoke(token)
                }
            } else {
                withContext(dispatcherProvider.main) {
                    onFail?.invoke()
                }
            }
        }
    }
}
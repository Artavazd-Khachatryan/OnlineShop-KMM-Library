package com.onlineshop.onlineshopkmmlibrary.useCases.authentication

import com.onlineshop.onlineshopkmmlibrary.async.DispatcherProvider
import com.onlineshop.onlineshopkmmlibrary.repository.TokenRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class CheckUserLoggedInUseCase(
    private val tokenRepository: TokenRepository,
    private val dispatcherProvider: DispatcherProvider
) {

    var onResult: ((isLoggedIn: Boolean) -> Unit)? = null

    fun execute() {
        CoroutineScope(dispatcherProvider.io).launch {
            val token = tokenRepository.getToken()
            onResult?.invoke(token != null)
        }
    }
}
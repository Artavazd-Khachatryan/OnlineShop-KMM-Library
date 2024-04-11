package com.onlineshop.onlineshopkmmlibrary.useCases

import com.onlineshop.onlineshopkmmlibrary.async.DispatcherProvider
import com.onlineshop.onlineshopkmmlibrary.networking.model.Token
import com.onlineshop.onlineshopkmmlibrary.repository.TokenRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class LoadTokenUseCase(
    private val tokenRepository: TokenRepository,
    private val dispatcherProvider: DispatcherProvider
) {

    var onSuccess: ((Token) -> Unit)? = null
    var onFail: (() -> Unit)? = null

    fun execute() {
        CoroutineScope(dispatcherProvider.io).launch {
            try {
                val result = tokenRepository.getToken()
                onSuccess?.invoke(result!!)
            } catch (e: Exception) {
                onFail?.invoke()
            }
        }
    }
}
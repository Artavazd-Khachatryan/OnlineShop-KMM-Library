package com.onlineshop.onlineshopkmmlibrary.useCases

import com.onlineshop.onlineshopkmmlibrary.async.DispatcherProvider
import com.onlineshop.onlineshopkmmlibrary.networking.OnlineShopClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class LoadTestDataUseCase(
    private val onlineShopClient: OnlineShopClient,
    private val dispatcherProvider: DispatcherProvider
) {

    var onSuccess: ((String) -> Unit)? = null
    var onFail: (() -> Unit)? = null

   fun execute() {
        CoroutineScope(dispatcherProvider.io).launch {
            try {
                val result = onlineShopClient.testCall()
                onSuccess?.invoke(result)
            } catch (e: Exception) {
                onFail?.invoke()
            }
        }
    }

}
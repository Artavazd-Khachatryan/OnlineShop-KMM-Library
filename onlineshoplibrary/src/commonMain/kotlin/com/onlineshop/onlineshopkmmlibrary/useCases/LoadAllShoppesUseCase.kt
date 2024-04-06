package com.onlineshop.onlineshopkmmlibrary.useCases

import com.onlineshop.onlineshopkmmlibrary.async.DispatcherProvider
import com.onlineshop.onlineshopkmmlibrary.networking.model.ShopEntity
import com.onlineshop.onlineshopkmmlibrary.repository.ShopRepository
import kotlinx.coroutines.*

class LoadAllShoppesUseCase(
    private var shopRepository: ShopRepository,
    private val dispatcherProvider: DispatcherProvider
) {

    var onSuccess: ((List<ShopEntity>) -> Unit)? = null
    var onFail: (() -> Unit)? = null

    fun execute() {
        CoroutineScope(dispatcherProvider.io).launch {
            try {
                val shops = shopRepository.getAllShops()
                withContext(dispatcherProvider.main) {
                    onSuccess?.invoke(shops)
                }
            } catch (e: Exception) {
                withContext(dispatcherProvider.main) {
                    onFail?.invoke()
                }
            }
        }
    }
}
package com.onlineshop.onlineshopkmmlibrary.useCases

import com.onlineshop.onlineshopkmmlibrary.async.DispatcherProvider
import com.onlineshop.onlineshopkmmlibrary.model.ProductEntity
import com.onlineshop.onlineshopkmmlibrary.repository.ProductRepository
import kotlinx.coroutines.*

class LoadAllProductsUseCase(
    private val productRepository: ProductRepository,
    private val dispatcherProvider: DispatcherProvider
) {

    var onSuccess: ((List<ProductEntity>) -> Unit)? = null
    var onFail: (() -> Unit)? = null

    fun execute(shopId: Long) {
        CoroutineScope(dispatcherProvider.io).launch {
            try {
                val products = productRepository.getProducts(shopId)
                withContext(dispatcherProvider.main) {
                    onSuccess?.invoke(products)
                }
            } catch (e: Exception) {
                withContext(dispatcherProvider.main) {
                    onFail?.invoke()
                }
            }
        }
    }
}
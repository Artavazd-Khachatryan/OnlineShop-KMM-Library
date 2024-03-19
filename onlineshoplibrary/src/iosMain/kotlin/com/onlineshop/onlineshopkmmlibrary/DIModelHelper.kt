package com.onlineshop.onlineshopkmmlibrary

import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllProductsUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllShoppesUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadTestDataUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DIModelHelper: KoinComponent {

    private val loadAllShoppesUseCase: LoadAllShoppesUseCase by inject()
    private val loadAllProductsUseCase: LoadAllProductsUseCase by inject()
    private val loadTestDataUseCase: LoadTestDataUseCase by inject()

    fun getLoadAllShoppesUseCase() = loadAllShoppesUseCase

    fun getLoadAllProductsUseCase() = loadAllProductsUseCase

    fun getLoadTestDataUseCase() = loadTestDataUseCase
}
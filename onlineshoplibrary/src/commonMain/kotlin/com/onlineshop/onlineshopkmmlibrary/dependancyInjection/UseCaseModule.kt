package com.onlineshop.onlineshopkmmlibrary.dependancyInjection

import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllProductsUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllShoppesUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadTestDataUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<LoadAllShoppesUseCase> { LoadAllShoppesUseCase(get(), get()) }

    factory { LoadAllProductsUseCase(get(), get()) }

    factory { LoadTestDataUseCase(get(), get()) }
}
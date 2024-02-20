package com.onlineshop.onlineshopkmmlibrary.dependancy_injection

import com.onlineshop.onlineshopkmmlibrary.async.DispatcherProvider
import com.onlineshop.onlineshopkmmlibrary.datasource.TestDataSource
import com.onlineshop.onlineshopkmmlibrary.repository.NetworkProductRepository
import com.onlineshop.onlineshopkmmlibrary.repository.NetworkShopRepository
import com.onlineshop.onlineshopkmmlibrary.repository.ProductRepository
import com.onlineshop.onlineshopkmmlibrary.repository.ShopRepository
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllProductsUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllShoppesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin() {
    startKoin {
        koinModules()
    }
}

fun KoinApplication.koinModules() = modules(appModule(), diModule())

fun appModule() = module {
    factory<ShopRepository> { NetworkShopRepository(get()) }

    factory<ProductRepository> { NetworkProductRepository(get()) }

    factory<TestDataSource> { TestDataSource() }

    factory<LoadAllShoppesUseCase> { LoadAllShoppesUseCase(get(), get()) }

    factory { LoadAllProductsUseCase(get(), get()) }
}

fun diModule() = module {
    factory<DispatcherProvider> {
        DispatcherProvider(
            main = Dispatchers.Main,
            io = Dispatchers.IO
        )
    }
}
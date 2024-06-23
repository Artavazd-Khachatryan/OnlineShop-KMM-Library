package com.onlineshop.onlineshopkmmlibrary.dependancyInjection

import com.onlineshop.onlineshopkmmlibrary.datasource.TestDataSource
import com.onlineshop.onlineshopkmmlibrary.repository.NetworkProductRepository
import com.onlineshop.onlineshopkmmlibrary.repository.NetworkShopRepository
import com.onlineshop.onlineshopkmmlibrary.repository.ProductRepository
import com.onlineshop.onlineshopkmmlibrary.repository.ShopRepository
import org.koin.core.KoinApplication
import org.koin.dsl.module

fun KoinApplication.initKoin() {
    shopLibraryKoinModules()
}

fun KoinApplication.shopLibraryKoinModules() = modules(repositoryModule(), asyncModule(), networking(), databaseModule(), useCaseModule, sqlDelightDriverModule)

fun repositoryModule() = module {
    factory<ShopRepository> {
        NetworkShopRepository(get())
    }

    factory<ProductRepository> { NetworkProductRepository(get()) }

    factory<TestDataSource> { TestDataSource() }
}

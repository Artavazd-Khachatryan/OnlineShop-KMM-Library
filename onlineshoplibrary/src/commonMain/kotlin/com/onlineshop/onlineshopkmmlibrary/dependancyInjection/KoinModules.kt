package com.onlineshop.onlineshopkmmlibrary.dependancyInjection

import com.onlineshop.onlineshopkmmlibrary.datasource.TestDataSource
import com.onlineshop.onlineshopkmmlibrary.repository.NetworkProductRepository
import com.onlineshop.onlineshopkmmlibrary.repository.NetworkShopRepository
import com.onlineshop.onlineshopkmmlibrary.repository.ProductRepository
import com.onlineshop.onlineshopkmmlibrary.repository.ShopRepository
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllProductsUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllShoppesUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadTestDataUseCase
import org.koin.core.KoinApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module

object Qualifiers {
    val BaseUrl = named("BaseUrl")
}

fun KoinApplication.initKoin() {
    shopLibraryKoinModules()
}

fun KoinApplication.shopLibraryKoinModules() = modules(appModule(), asyncModule(), networking(), databaseModule(), useCaseModule, sqlDelightDriverModule)

fun appModule() = module {
    factory<ShopRepository> {
        NetworkShopRepository(get())
    }

    factory<ProductRepository> { NetworkProductRepository(get()) }

    factory<TestDataSource> { TestDataSource() }
}

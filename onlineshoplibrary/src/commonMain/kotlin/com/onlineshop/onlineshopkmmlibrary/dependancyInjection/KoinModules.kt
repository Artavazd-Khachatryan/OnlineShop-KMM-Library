package com.onlineshop.onlineshopkmmlibrary.dependancyInjection

import com.onlineshop.onlineshopkmmlibrary.datasource.TestDataSource
import com.onlineshop.onlineshopkmmlibrary.repository.NetworkProductRepository
import com.onlineshop.onlineshopkmmlibrary.repository.NetworkShopRepository
import com.onlineshop.onlineshopkmmlibrary.repository.ProductRepository
import com.onlineshop.onlineshopkmmlibrary.repository.ShopRepository
import org.koin.core.KoinApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module

object Qualifiers {
    val BaseUrl = named("BaseUrl")
}

fun KoinApplication.initKoin() {
    shopLibraryKoinModules()
}

fun KoinApplication.shopLibraryKoinModules() = modules(dataSourceModule(), asyncModule(), networking(), databaseModule(), useCaseModule, sqlDelightDriverModule)

fun dataSourceModule() = module {
    factory<ShopRepository> {
        NetworkShopRepository(get())
    }

    factory<ProductRepository> { NetworkProductRepository(get()) }

    factory<TestDataSource> { TestDataSource() }
}

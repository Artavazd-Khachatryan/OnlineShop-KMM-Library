package com.onlineshop.onlineshopkmmlibrary.dependancyInjection

import com.onlineshop.database.OnlineShopDB
import com.onlineshop.onlineshopkmmlibrary.async.DispatcherProvider
import com.onlineshop.onlineshopkmmlibrary.datasource.TestDataSource
import com.onlineshop.onlineshopkmmlibrary.datasource.createDatabase
import com.onlineshop.onlineshopkmmlibrary.httpClient
import com.onlineshop.onlineshopkmmlibrary.networking.OnlineShopClient
import com.onlineshop.onlineshopkmmlibrary.networking.OnlineShopClientImpl
import com.onlineshop.onlineshopkmmlibrary.repository.NetworkProductRepository
import com.onlineshop.onlineshopkmmlibrary.repository.NetworkShopRepository
import com.onlineshop.onlineshopkmmlibrary.repository.ProductRepository
import com.onlineshop.onlineshopkmmlibrary.repository.ShopRepository
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllProductsUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllShoppesUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadTestDataUseCase
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.KoinApplication
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

object Qualifiers {
    val BaseUrl = named("BaseUrl")
}

fun KoinApplication.initKoin() {
    shopLibraryKoinModules()
}

fun KoinApplication.shopLibraryKoinModules() = modules(appModule(), asyncModule(), networking(), databaseModule(), sqlDelightDriverModule)

fun appModule() = module {
    factory<ShopRepository> {
        NetworkShopRepository(get())
    }

    factory<ProductRepository> { NetworkProductRepository(get()) }

    factory<TestDataSource> { TestDataSource() }

    factory<LoadAllShoppesUseCase> { LoadAllShoppesUseCase(get(), get()) }

    factory { LoadAllProductsUseCase(get(), get()) }

    factory { LoadTestDataUseCase(get(), get())}
}

fun asyncModule() = module {
    factory<DispatcherProvider> {
        DispatcherProvider(
            main = Dispatchers.Main,
            io = Dispatchers.IO
        )
    }
}

fun networking() = module {

    factory(Qualifiers.BaseUrl) { "localhost:8080/api/v1/" }

    factory {
        httpClient {
            install(Logging)
            install(ContentNegotiation) {
                json()
            }
        }
    }

    factory<OnlineShopClient> { OnlineShopClientImpl(get()) }
}

fun databaseModule() = module {
    single<OnlineShopDB> { createDatabase(get()) }
}

expect val sqlDelightDriverModule: Module

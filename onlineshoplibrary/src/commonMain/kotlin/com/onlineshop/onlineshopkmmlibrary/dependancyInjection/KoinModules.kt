package com.onlineshop.onlineshopkmmlibrary.dependancyInjection

import com.onlineshop.onlineshopkmmlibrary.async.DispatcherProvider
import com.onlineshop.onlineshopkmmlibrary.datasource.TestDataSource
import com.onlineshop.onlineshopkmmlibrary.httpClient
import com.onlineshop.onlineshopkmmlibrary.repository.NetworkProductRepository
import com.onlineshop.onlineshopkmmlibrary.repository.NetworkShopRepository
import com.onlineshop.onlineshopkmmlibrary.repository.ProductRepository
import com.onlineshop.onlineshopkmmlibrary.repository.ShopRepository
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllProductsUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllShoppesUseCase
import io.ktor.client.plugins.logging.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

object Qualifiers {
    val BaseUrl = named("BaseUrl")
    val Login = named("Login")
}


fun initKoin() {
    startKoin {
        koinModules()
    }
}

fun KoinApplication.koinModules() = modules(appModule(), asyncModule(), networking())

fun appModule() = module {
    factory<ShopRepository> { NetworkShopRepository(get()) }

    factory<ProductRepository> { NetworkProductRepository(get()) }

    factory<TestDataSource> { TestDataSource() }

    factory<LoadAllShoppesUseCase> { LoadAllShoppesUseCase(get(), get()) }

    factory { LoadAllProductsUseCase(get(), get()) }
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

    factory(Qualifiers.Login) {
        httpClient {
            install(Logging)
        }
    }

    factory {
        httpClient {
           install(Logging)
        }
    }

    // factory { OnlineShopClient(get()) }
}
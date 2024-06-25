package com.onlineshop.onlineshopkmmlibrary.dependancyInjection

import com.onlineshop.database.OnlineShopDB
import com.onlineshop.onlineshopkmmlibrary.datasource.createDatabase
import com.onlineshop.onlineshopkmmlibrary.repository.TokenRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val databaseModule = module {

    factory { TokenRepository(get<OnlineShopDB>().tokenEntityQueries) }

    single<OnlineShopDB> { createDatabase(get()) }
}

expect val sqlDelightDriverModule: Module
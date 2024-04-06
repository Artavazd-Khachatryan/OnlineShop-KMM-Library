package com.onlineshop.onlineshopkmmlibrary.dependancyInjection

import com.onlineshop.database.OnlineShopDB
import com.onlineshop.onlineshopkmmlibrary.datasource.createDatabase
import com.onlineshop.onlineshopkmmlibrary.repository.LocalTokenRepository
import org.koin.core.module.Module
import org.koin.dsl.module

fun databaseModule() = module {

    factory { LocalTokenRepository(get<OnlineShopDB>().tokenEntityQueries) }

    single<OnlineShopDB> { createDatabase(get()) }
}

expect val sqlDelightDriverModule: Module
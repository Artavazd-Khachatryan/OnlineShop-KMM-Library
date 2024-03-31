package com.onlineshop.onlineshopkmmlibrary.dependancyInjection

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.onlineshop.database.OnlineShopDB
import org.koin.core.module.Module
import org.koin.dsl.module

actual val sqlDelightTestDriverModule: Module = module {
    factory<SqlDriver> {
       JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY).also {
           OnlineShopDB.Schema.create(it)
       }
    }
}

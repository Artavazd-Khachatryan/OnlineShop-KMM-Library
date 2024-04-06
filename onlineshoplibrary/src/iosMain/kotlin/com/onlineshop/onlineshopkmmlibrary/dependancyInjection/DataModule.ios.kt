package com.onlineshop.onlineshopkmmlibrary.dependancyInjection

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.onlineshop.database.OnlineShopDB
import com.onlineshop.onlineshopkmmlibrary.datasource.DB_NAME
import org.koin.core.module.Module
import org.koin.dsl.module

actual val sqlDelightDriverModule: Module = module {
    factory<SqlDriver> {
        NativeSqliteDriver(OnlineShopDB.Schema, DB_NAME)
    }
}

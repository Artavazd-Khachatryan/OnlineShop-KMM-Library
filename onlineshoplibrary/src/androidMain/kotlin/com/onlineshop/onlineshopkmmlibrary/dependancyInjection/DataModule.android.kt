package com.onlineshop.onlineshopkmmlibrary.dependancyInjection

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.onlineshop.database.OnlineShopDB
import com.onlineshop.onlineshopkmmlibrary.datasource.DB_NAME
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext

actual val sqlDelightDriverModule: Module = module {
    factory<SqlDriver> {
        AndroidSqliteDriver(OnlineShopDB.Schema, androidContext(), DB_NAME)
    }
}

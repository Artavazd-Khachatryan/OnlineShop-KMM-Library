package com.onlineshop.onlineshopkmmlibrary.datasource

import app.cash.sqldelight.db.SqlDriver
import com.onlineshop.database.OnlineShopDB

val DB_NAME = "onlineshop.db"

fun createDatabase(driver: SqlDriver): OnlineShopDB {
    return OnlineShopDB(driver)
}
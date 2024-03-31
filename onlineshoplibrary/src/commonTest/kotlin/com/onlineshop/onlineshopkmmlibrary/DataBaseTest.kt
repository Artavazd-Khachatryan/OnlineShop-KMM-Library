package com.onlineshop.onlineshopkmmlibrary

import com.onlineshop.database.OnlineShopDB
import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.appModule
import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.databaseModule
import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.sqlDelightTestDriverModule
import kotlinx.coroutines.test.runTest
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class DataBaseTest: KoinTest {

    private val onlineShopDB: OnlineShopDB by inject()

    @BeforeTest
    fun setup() = runTest {
        startKoin {
            modules(
                appModule(),
                databaseModule(),
                sqlDelightTestDriverModule
            )
        }
    }

    @Test
    fun testDatabase() {
        onlineShopDB.personEntityQueries.insertPerson(0, firstName = "John", lastName = "Doe")
        val person = onlineShopDB.personEntityQueries.getPersonById(0).executeAsOne()
        assertTrue(person.firstName == "John")
    }
}
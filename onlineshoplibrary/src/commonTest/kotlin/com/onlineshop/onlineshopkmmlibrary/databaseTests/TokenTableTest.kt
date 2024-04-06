package com.onlineshop.onlineshopkmmlibrary.databaseTests

import com.onlineshop.database.OnlineShopDB
import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.appModule
import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.databaseModule
import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.sqlDelightTestDriverModule
import com.onlineshop.onlineshopkmmlibrary.networking.model.Token
import comonlineshopdatabase.TokenEntity
import kotlinx.coroutines.test.runTest
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.*

class TokenTableTest : KoinTest {

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

    @AfterTest
    fun clean() {
        stopKoin()
    }

    @Test
    fun testTokenTable() {
        val expectedToken = Token(
            accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huLmRvZUBleGFtcGxlLmNvbSIsImlhdCI6MTcxMjQwNDk2MSwiZXhwIjoxNzEyNDkxMzYxfQ.EBvuT7D8dgMmH14XyPtofdnLha3tsVSQdaLr8heHb4M",
            refreshToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huLmRvZUBleGFtcGxlLmNvbSIsImlhdCI6MTcxMjQwNDk2MSwiZXhwIjoxNzEzMDA5NzYxfQ.bYFNPHgf4-RgRqcavXmc6e4Ls5goI3MJyHUfM_qu3J8"
        )
        val tokenTable = onlineShopDB.tokenEntityQueries
        tokenTable.insertToken(expectedToken.accessToken, expectedToken.refreshToken)
        var actualToken: TokenEntity? = tokenTable.getToken().executeAsOne()

        assertEquals(expectedToken.accessToken, actualToken?.accessToken)
        assertEquals(expectedToken.refreshToken, actualToken?.refreshToken)

        tokenTable.deleteToken()
        actualToken = tokenTable.getToken().executeAsOneOrNull()
        assertNull(actualToken)
    }
}
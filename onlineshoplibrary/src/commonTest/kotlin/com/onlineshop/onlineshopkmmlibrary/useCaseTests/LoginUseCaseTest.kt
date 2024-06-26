package com.onlineshop.onlineshopkmmlibrary.useCaseTests

import com.onlineshop.onlineshopkmmlibrary.async.DispatcherProvider
import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.apiModule
import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.clientModule
import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.databaseModule
import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.networkTestDomainModule
import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.sqlDelightTestDriverModule
import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.useCaseModule
import com.onlineshop.onlineshopkmmlibrary.useCases.LoginUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

// TODO Cover more test cases
class LoginUseCaseTest : KoinTest {

    private val loginUseCase: LoginUseCase by inject()

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeTest
    fun setup() = runTest {
        startKoin {
            modules(
                useCaseModule,
                databaseModule,
                sqlDelightTestDriverModule,
                apiModule,
                clientModule,
                networkTestDomainModule,
                module {
                    factory<DispatcherProvider> {
                        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
                        DispatcherProvider(
                            main = testDispatcher,
                            io = testDispatcher
                        )
                    }
                },
            )
        }
    }

    @AfterTest
    fun clean() {
        stopKoin()
    }

    @Test
    fun testLogin_validCredentials_Success() = runBlocking {
        var loginSuccess = false
        loginUseCase
            .apply {
                onSuccess = {
                    loginSuccess = true
                }
            }
            .execute("john.doe@example.com", "password")
        delay(1000)
        assertTrue(loginSuccess)
    }
}
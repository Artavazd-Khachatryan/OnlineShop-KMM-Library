package com.onlineshop.onlineshopkmmlibrary.useCaseTests

import com.onlineshop.onlineshopkmmlibrary.async.DispatcherProvider
import com.onlineshop.onlineshopkmmlibrary.datasource.TestDataSource
import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.repositoryModule
import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.useCaseModule
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllShoppesUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class LoadShopsTest : KoinTest {

    private val loadAllShoppesUseCase: LoadAllShoppesUseCase by inject()
    private val testDataSource: TestDataSource by inject()

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeTest
    fun setup() = runTest {
        startKoin {
            modules(
                repositoryModule,
                useCaseModule,
                module {
                    factory<DispatcherProvider> {
                        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
                        DispatcherProvider(
                            main = testDispatcher,
                            io = testDispatcher
                        )
                    }
                })
        }
    }

    @AfterTest
    fun clean() {
        stopKoin()
    }

    @Test
    fun testLoadingShops_Success() = runTest {
        loadAllShoppesUseCase.apply {
            onSuccess = { shops ->
                assertEquals(testDataSource.shopList, shops)
            }
            onFail = {}
        }.execute()
    }
}
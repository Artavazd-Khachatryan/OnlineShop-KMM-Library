package com.onlineshop.onlineshopkmmlibrary.useCaseTests

import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.dataSourceModule
import com.onlineshop.onlineshopkmmlibrary.async.DispatcherProvider
import com.onlineshop.onlineshopkmmlibrary.datasource.TestDataSource
import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.useCaseModule
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllProductsUseCase
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
import kotlin.test.assertEquals

class LoadProductsTest : KoinTest {

    private val testDataSource: TestDataSource by inject()
    private val loadAllProductsUseCase: LoadAllProductsUseCase by inject()

    @BeforeTest
    fun setup() = runTest {
        startKoin {
            modules(
                dataSourceModule(),
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
    fun testLoadProducts_Success() = runTest {
        val expectedResult = testDataSource.productList.filter { it.shop == 1L }
        loadAllProductsUseCase.apply {
            onSuccess = { products ->
                assertEquals(expectedResult, products)
            }
            onFail = {}
        }.execute(1L)
    }

}
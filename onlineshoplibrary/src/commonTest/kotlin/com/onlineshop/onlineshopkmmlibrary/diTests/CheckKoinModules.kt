package com.onlineshop.onlineshopkmmlibrary.diTests

import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.shopLibraryKoinModules
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import kotlin.test.Test

class CheckKoinModules: KoinTest {

    @Test
    fun checkKoinModules() {
        checkModules {
            shopLibraryKoinModules
        }
    }
}
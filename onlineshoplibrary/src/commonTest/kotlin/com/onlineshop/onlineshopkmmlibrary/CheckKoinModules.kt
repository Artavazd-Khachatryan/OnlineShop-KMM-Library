package com.onlineshop.onlineshopkmmlibrary

import com.onlineshop.onlineshopkmmlibrary.dependancy_injection.koinModules
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import kotlin.test.Test

class CheckKoinModules: KoinTest {

    @Test
    fun checkKoinModules() {
        checkModules {
            koinModules()
        }
    }
}
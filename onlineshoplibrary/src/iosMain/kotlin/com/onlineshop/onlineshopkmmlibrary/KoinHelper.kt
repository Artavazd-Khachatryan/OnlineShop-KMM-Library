package com.onlineshop.onlineshopkmmlibrary

import com.onlineshop.onlineshopkmmlibrary.dependancyInjection.shopLibraryKoinModules
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        shopLibraryKoinModules
    }
}
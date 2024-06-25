package com.onlineshop.onlineshopkmmlibrary.dependancyInjection

import org.koin.core.module.Module
import org.koin.dsl.module

expect val sqlDelightTestDriverModule: Module

private const val localhostTest: String = "http://localhost:8080"

val networkTestDomainModule: Module = module {
    single<String>(qualifier = LOCALHOST) {
        localhostTest
    }
}

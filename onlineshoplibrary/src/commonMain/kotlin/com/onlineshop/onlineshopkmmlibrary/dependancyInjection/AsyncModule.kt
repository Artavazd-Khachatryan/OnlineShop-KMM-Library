package com.onlineshop.onlineshopkmmlibrary.dependancyInjection

import com.onlineshop.onlineshopkmmlibrary.async.DispatcherProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module

val asyncModule = module {
    factory<DispatcherProvider> {
        DispatcherProvider(
            main = Dispatchers.Main,
            io = Dispatchers.IO
        )
    }
}
package com.onlineshop.onlineshopkmmlibrary.dependancyInjection

import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllProductsUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllShoppesUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadTestDataUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.authentication.CheckUserLoggedInUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.authentication.LoginUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.authentication.RegistrationUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { LoginUseCase(get(), get(), get()) }

    factory { RegistrationUseCase(get(), get(), get()) }

    factory { CheckUserLoggedInUseCase(get(), get()) }

    factory<LoadAllShoppesUseCase> { LoadAllShoppesUseCase(get(), get()) }

    factory { LoadAllProductsUseCase(get(), get()) }

    factory { LoadTestDataUseCase(get(), get()) }
}
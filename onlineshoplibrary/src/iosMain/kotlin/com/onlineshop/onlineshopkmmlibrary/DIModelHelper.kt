package com.onlineshop.onlineshopkmmlibrary

import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllProductsUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadAllShoppesUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.LoadTestDataUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.authentication.CheckUserLoggedInUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.authentication.LoginUseCase
import com.onlineshop.onlineshopkmmlibrary.useCases.authentication.RegistrationUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DIModelHelper: KoinComponent {

    private val loadAllShoppesUseCase: LoadAllShoppesUseCase by inject()
    private val loadAllProductsUseCase: LoadAllProductsUseCase by inject()
    private val loadTestDataUseCase: LoadTestDataUseCase by inject()
    private val loginUseCase: LoginUseCase by inject()
    private val registrationUseCase: RegistrationUseCase by inject()
    private val checkUserLoggedInUseCase: CheckUserLoggedInUseCase by inject()

    fun getLoadAllShoppesUseCase() = loadAllShoppesUseCase

    fun getLoadAllProductsUseCase() = loadAllProductsUseCase

    fun getLoadTestDataUseCase() = loadTestDataUseCase

    fun getLoginUseCase() = loginUseCase

    fun getRegistrationUseCase() = registrationUseCase

    fun getCheckUserLoggedInUseCase() = checkUserLoggedInUseCase
}
package com.onlineshop.onlineshopkmmlibrary.async

import kotlinx.coroutines.CoroutineDispatcher

class DispatcherProvider(
    val main: CoroutineDispatcher,
    val io: CoroutineDispatcher
)
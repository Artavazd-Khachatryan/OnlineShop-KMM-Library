package com.onlineshop.onlineshopkmmlibrary

import io.ktor.client.*

expect fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient


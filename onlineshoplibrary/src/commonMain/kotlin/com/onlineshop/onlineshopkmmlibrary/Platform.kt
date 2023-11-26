package com.onlineshop.onlineshopkmmlibrary

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
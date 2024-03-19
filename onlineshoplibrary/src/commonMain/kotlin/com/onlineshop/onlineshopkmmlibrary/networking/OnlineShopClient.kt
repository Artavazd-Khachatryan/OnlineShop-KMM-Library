package com.onlineshop.onlineshopkmmlibrary.networking

interface OnlineShopClient {

    suspend fun testCall(): String
    // shop
    // post    /api/v1/shop
    // get     /api/v1/shop
    // get     /api/v1/shop/{id}
    // delete  /api/v1/shop/{id}

}
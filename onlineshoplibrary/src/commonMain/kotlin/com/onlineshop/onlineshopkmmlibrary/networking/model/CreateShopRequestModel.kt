package com.onlineshop.onlineshopkmmlibrary.networking.model

import kotlinx.serialization.Serializable

@Serializable
class CreateShopRequestModel(val name: String, val description: String)
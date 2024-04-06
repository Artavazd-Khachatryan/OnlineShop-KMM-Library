package com.onlineshop.onlineshopkmmlibrary.datasource

import com.onlineshop.onlineshopkmmlibrary.networking.model.ProductEntity
import com.onlineshop.onlineshopkmmlibrary.networking.model.ShopEntity

class TestDataSource {

    val shopList = listOf(
        ShopEntity(1, "ElectroMart", "Best place to find Electronics at affordable prices!"),
        ShopEntity(2, "Gadget Galaxy", "Your one-stop shop for all your gadget needs."),
        ShopEntity(3, "Tech World", "Cutting-edge electronics for the tech-savvy individual."),
        ShopEntity(4, "Digital Haven", "Your haven for all things digital."),
        ShopEntity(5, "Innovate Electronics", "Bringing innovation to your doorstep."),
        ShopEntity(6, "Gizmo Emporium", "A paradise for gadget enthusiasts."),
        ShopEntity(7, "The Tech Hub", "Your hub for all the latest tech gadgets."),
        ShopEntity(8, "ElectroBazaar", "Where electronics meet affordability."),
        ShopEntity(9, "Device Depot", "Get your devices here at unbeatable prices."),
        ShopEntity(10, "Gadget Zone", "Explore the world of gadgets with us.")
    )

    val productList = listOf(
        ProductEntity(1, 1, "Smartphone", "Description for Smartphone Electronics", 299.99, "Electronics"),
        ProductEntity(2, 1, "Laptop", "Description for Laptop Electronics", 799.99, "Electronics"),
        ProductEntity(3, 1, "Headphones", "Description for Headphones Electronics", 99.99, "Electronics"),
        ProductEntity(4, 1, "Smartwatch", "Description for Smartwatch Electronics", 199.99, "Electronics"),
        ProductEntity(5, 1, "Tablet", "Description for Tablet Electronics", 249.99, "Electronics"),
        ProductEntity(6, 2, "Camera", "Description for Camera Electronics", 399.99, "Electronics"),
        ProductEntity(7, 2, "Television", "Description for Television Electronics", 599.99, "Electronics"),
        ProductEntity(8, 2, "Gaming Console", "Description for Gaming Console Electronics", 499.99, "Electronics"),
        ProductEntity(9, 2, "Fitness Tracker", "Description for Fitness Tracker Electronics", 149.99, "Electronics"),
        ProductEntity(10, 2, "Wireless Earbuds", "Description for Wireless Earbuds Electronics", 129.99, "Electronics"),
        ProductEntity(11, 3, "Designer Dress", "Description for Designer Dress Clothing", 199.99, "Clothing"),
        ProductEntity(12, 3, "Leather Jacket", "Description for Leather Jacket Clothing", 249.99, "Clothing"),
        ProductEntity(13, 3, "Casual Jeans", "Description for Casual Jeans Clothing", 79.99, "Clothing"),
        ProductEntity(14, 3, "Running Shoes", "Description for Running Shoes Clothing", 129.99, "Clothing"),
        ProductEntity(15, 3, "Sunglasses", "Description for Sunglasses Clothing", 49.99, "Clothing"),
        ProductEntity(16, 4, "Classic Novel", "Description for Classic Novel Books", 14.99, "Books"),
        ProductEntity(17, 4, "Self-Help Book", "Description for Self-Help Book Books", 19.99, "Books"),
        ProductEntity(18, 4, "Fantasy Series", "Description for Fantasy Series Books", 29.99, "Books"),
        ProductEntity(19, 4, "Mystery Thriller", "Description for Mystery Thriller Books", 24.99, "Books"),
        ProductEntity(20, 4, "Cookbook", "Description for Cookbook Books", 34.99, "Books"),
        ProductEntity(21, 5, "Home Security System", "Description for Home Security System Electronics", 199.99, "Electronics"),
        ProductEntity(22, 5, "Smart Thermostat", "Description for Smart Thermostat Electronics", 129.99, "Electronics"),
        ProductEntity(23, 5, "Robot Vacuum Cleaner", "Description for Robot Vacuum Cleaner Electronics", 299.99, "Electronics"),
        ProductEntity(24, 5, "Smart Doorbell", "Description for Smart Doorbell Electronics", 149.99, "Electronics"),
        ProductEntity(25, 5, "Wireless Security Camera", "Description for Wireless Security Camera Electronics", 99.99, "Electronics"),
        ProductEntity(26, 6, "Gaming Mouse", "Description for Gaming Mouse Electronics", 49.99, "Electronics"),
        ProductEntity(27, 6, "Mechanical Keyboard", "Description for Mechanical Keyboard Electronics", 99.99, "Electronics"),
        ProductEntity(28, 6, "RGB Gaming Headset", "Description for RGB Gaming Headset Electronics", 79.99, "Electronics"),
        ProductEntity(29, 6, "Gaming Chair", "Description for Gaming Chair Electronics", 199.99, "Electronics"),
        ProductEntity(30, 6, "Gaming Desk", "Description for Gaming Desk Electronics", 149.99, "Electronics"),
        ProductEntity(31, 7, "Portable Bluetooth Speaker", "Description for Portable Bluetooth Speaker Electronics", 29.99, "Electronics"),
        ProductEntity(32, 7, "Wireless Earphones", "Description for Wireless Earphones Electronics", 39.99, "Electronics"),
        ProductEntity(33, 7, "Power Bank", "Description for Power Bank Electronics", 19.99, "Electronics"),
        ProductEntity(34, 7, "Car Charger", "Description for Car Charger Electronics", 9.99, "Electronics"),
        ProductEntity(35, 7, "Smartphone Stand", "Description for Smartphone Stand Electronics", 14.99, "Electronics"),
        ProductEntity(36, 8, "Coffee Maker", "Description for Coffee Maker Electronics", 49.99, "Electronics"),
        ProductEntity(37, 8, "Blender", "Description for Blender Electronics", 39.99, "Electronics"),
        ProductEntity(38, 8, "Toaster", "Description for Toaster Electronics", 29.99, "Electronics"),
        ProductEntity(39, 8, "Microwave Oven", "Description for Microwave Oven Electronics", 99.99, "Electronics"),
        ProductEntity(40, 8, "Food Processor", "Description for Food Processor Electronics", 79.99, "Electronics"),
        ProductEntity(41, 9, "Bluetooth Car Stereo", "Description for Bluetooth Car Stereo Electronics", 99.99, "Electronics"),
        ProductEntity(42, 9, "Car GPS Navigation System", "Description for Car GPS Navigation System Electronics", 149.99, "Electronics"),
        ProductEntity(43, 9, "Dash Cam", "Description for Dash Cam Electronics", 79.99, "Electronics"),
        ProductEntity(44, 9, "Car Alarm System", "Description for Car Alarm", 89.99, "Electronics")
    )
}
package miu.mdp.assignment5.cart.data

import miu.mdp.assignment5.R

interface ProductRepository {
    suspend fun getProducts(): List<Product>
}

class ProductRepositoryImpl : ProductRepository {

    override suspend fun getProducts() = listOf(
        Product(R.drawable.ic_ipad, R.drawable.ic_brand_apple, "iPad", "iPad Pro 11-inch", 400.0),
        Product(R.drawable.ic_macbook, R.drawable.ic_brand_apple, "MacBook M3 Pro", "12-core CPU\n18-core GPU", 2500.00),
        Product(R.drawable.ic_dell, R.drawable.ic_brand_dell, "Dell Inspiron", "13th Gen Intel® CoreTM i7", 1499.00),
        Product(R.drawable.ic_logitech_keyboard, R.drawable.ic_brand_logitech, "Logitech Keyboard", "Logitech - PRO X\nTKL LIGHTSPEED Wireless", 199.00),
        Product(R.drawable.ic_macbook, R.drawable.ic_brand_apple, "MacBook M3 Max", "14-core CPU\n30-core GPU", 3499.00)
    )

}

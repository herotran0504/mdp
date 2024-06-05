package miu.mdp.assignment5.cart.data

import miu.mdp.assignment5.R
import miu.mdp.assignment5.cart.model.Product
import javax.inject.Inject

interface ProductRepository {
    suspend fun getProducts(): List<Product>
    suspend fun addProduct(product: Product)
}

internal class ProductRepositoryImpl @Inject constructor() : ProductRepository {
    private val products = mutableListOf<Product>()

    override suspend fun addProduct(product: Product) {
        products.add(product)
    }

    override suspend fun getProducts() = PRODUCTS

    companion object {
        val PRODUCTS = listOf(
            Product(
                productImage = R.drawable.ic_ipad,
                productLogo = R.drawable.ic_brand_apple,
                productName = "iPad",
                productDescription = "iPad Pro 11-inch",
                productCost = 400.0
            ),
            Product(
                productImage = R.drawable.ic_macbook,
                productLogo = R.drawable.ic_brand_apple,
                productName = "MacBook M3 Pro",
                productDescription = "12-core CPU\n18-core GPU",
                productCost = 2500.00
            ),
            Product(
                productImage = R.drawable.ic_dell,
                productLogo = R.drawable.ic_brand_dell,
                productName = "Dell Inspiration",
                productDescription = "13th Gen Intel® CoreTM i7",
                productCost = 1499.00
            ),
            Product(
                productImage = R.drawable.ic_logitech_keyboard,
                productLogo = R.drawable.ic_brand_logitech,
                productName = "Logitech Keyboard",
                productDescription = "Logitech - PRO X\nTKL LIGHTSPEED Wireless",
                productCost = 199.00
            ),
            Product(
                productImage = R.drawable.ic_macbook,
                productLogo = R.drawable.ic_brand_apple,
                productName = "MacBook M3 Max",
                productDescription = "14-core CPU\n30-core GPU",
                productCost = 3499.00
            )
        )
    }

}

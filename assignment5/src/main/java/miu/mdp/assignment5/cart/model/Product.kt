package miu.mdp.assignment5.cart.model

import java.util.*

data class Product(
    val productId: String = UUID.randomUUID().toString(),
    val productImage: Int,
    val productLogo: Int,
    val productName: String,
    val productDescription: String,
    val productCost: Double
)

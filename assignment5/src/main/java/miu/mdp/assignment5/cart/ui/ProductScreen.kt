package miu.mdp.assignment5.cart.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import miu.mdp.core.showToast

@Composable
fun ProductScreen(
    navController: NavController,
    viewModel: ProductViewModel = hiltViewModel()
) {
    val products by viewModel.products.collectAsState()
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.message.collect {
            context.showToast(it)
        }
    }

    ProductList(products, onProductClick = {
        navController.navigate("productDetails/${it.productId}")
    }, onAddToCartClick = {
        viewModel.addToCart(it)
    }, onViewCart = {
        viewModel.viewCart()
    })
}

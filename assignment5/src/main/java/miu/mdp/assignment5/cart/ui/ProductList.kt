package miu.mdp.assignment5.cart.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import miu.mdp.assignment5.R
import miu.mdp.assignment5.cart.data.ProductRepositoryImpl.Companion.PRODUCTS
import miu.mdp.assignment5.cart.model.Product

@Composable
fun ProductList(
    products: List<Product>,
    onProductClick: (Product) -> Unit,
    onAddToCartClick: (Product) -> Unit,
    onViewCart: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(products) {
                ProductItem(
                    product = it,
                    onProductClick = onProductClick,
                    onAddToCartClick = onAddToCartClick
                )
            }
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            onClick = onViewCart
        ) {
            Text(text = stringResource(R.string.cart_view_cart))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListPreview() {
    ProductList(
        products = PRODUCTS,
        onProductClick = {},
        onAddToCartClick = {},
        onViewCart = {}
    )
}
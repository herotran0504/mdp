package miu.mdp.assignment5.cart.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import miu.mdp.assignment5.R
import miu.mdp.assignment5.cart.data.ProductRepositoryImpl.Companion.PRODUCTS
import miu.mdp.assignment5.cart.model.Product

@Composable
fun ProductItem(
    product: Product,
    onProductClick: (Product) -> Unit,
    onAddToCartClick: (Product) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = ShapeDefaults.Small,
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.background(Color.White)
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { onProductClick(product) }
        ) {
            Image(
                modifier = Modifier.size(width = 150.dp, height = 150.dp),
                painter = painterResource(id = product.productImage), contentDescription = ""
            )
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Image(
                        modifier = Modifier.size(width = 36.dp, height = 36.dp),
                        painter = painterResource(id = product.productLogo), contentDescription = ""
                    )
                    Text(
                        text = product.productName,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(text = product.productDescription, fontSize = 14.sp)
                Text(text = "$${product.productCost}", fontSize = 16.sp)
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onAddToCartClick(product) }
                ) {
                    Text(text = stringResource(R.string.cart_add_to_cart))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        ProductItem(
            product = PRODUCTS[2],
            onProductClick = {},
            onAddToCartClick = {}
        )
    }
}
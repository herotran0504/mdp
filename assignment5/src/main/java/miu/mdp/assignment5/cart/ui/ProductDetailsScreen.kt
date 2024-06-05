package miu.mdp.assignment5.cart.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import miu.mdp.assignment5.R
import miu.mdp.assignment5.cart.data.ProductRepositoryImpl.Companion.PRODUCTS
import miu.mdp.assignment5.cart.model.Product
import miu.mdp.uikit.component.TopActionBar
import miu.mdp.uikit.theme.PurpleAmethyst

@Composable
fun ProductDetailsScreen(
    controller: NavController,
    productId: String,
    viewModel: ProductViewModel = hiltViewModel()
) {
    var product by remember { mutableStateOf<Product?>(null) }

    LaunchedEffect(productId) {
        product = viewModel.findProduct(productId)
    }

    product?.let {
        ProductDetails(product = it, onBack = { controller.navigateUp() })
    }
}

@Composable
fun ProductDetails(product: Product?, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopActionBar(
                title = stringResource(R.string.cart_details),
                containerColor = PurpleAmethyst,
                iconClick = onBack
            )
        },
        content = { paddingValues ->
            product?.let {
                Box(modifier = Modifier.padding(paddingValues).fillMaxSize()) {
                    Column(
                        modifier = Modifier.padding(16.dp).fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Image(
                            modifier = Modifier.size(150.dp),
                            painter = painterResource(id = it.productImage),
                            contentDescription = ""
                        )
                        Text(
                            text = it.productName,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = it.productDescription, fontSize = 16.sp)
                        Text(text = "$${it.productCost}", fontSize = 18.sp)
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailsPreview() {
    ProductDetails(PRODUCTS[2]) {}
}

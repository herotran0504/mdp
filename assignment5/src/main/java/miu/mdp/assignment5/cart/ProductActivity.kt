package miu.mdp.assignment5.cart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import miu.mdp.assignment5.cart.ui.ProductDetailsScreen
import miu.mdp.assignment5.cart.ui.ProductScreen

object NavRoutes {
    const val PRODUCT_LIST = "productList"
    const val PRODUCT_DETAILS = "productDetails"
}

object NavArguments {
    const val PRODUCT_ID = "productId"
}

@AndroidEntryPoint
class ProductActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductNavGraph()
        }
    }

    companion object {
        fun start(activityContext: Context) {
            activityContext.startActivity(Intent(activityContext, ProductActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }
    }
}

@Composable
fun ProductNavGraph() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = NavRoutes.PRODUCT_LIST) {
        composable(NavRoutes.PRODUCT_LIST) { ProductScreen(navController) }
        composable(
            "${NavRoutes.PRODUCT_DETAILS}/{${NavArguments.PRODUCT_ID}}",
            arguments = listOf(navArgument(NavArguments.PRODUCT_ID) { type = NavType.StringType })
        ) {
            val productId = it.arguments?.getString(NavArguments.PRODUCT_ID).orEmpty()
            ProductDetailsScreen(navController, productId)
        }
    }
}

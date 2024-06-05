package miu.mdp.assignment4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint
import miu.mdp.assignment4.data.CategoryRepository
import miu.mdp.assignment4.data.CategoryRepositoryImpl.Companion.CATEGORIES
import miu.mdp.assignment4.data.UserState
import miu.mdp.assignment4.model.Category
import miu.mdp.core.showToast
import javax.inject.Inject

@AndroidEntryPoint
class ShoppingCategoryActivity : ComponentActivity() {

    @Inject
    lateinit var repository: CategoryRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val greeting = getString(R.string.e_welcome, UserState.currentUser?.name.orEmpty())
            val categories = repository.getCategories()
            ShoppingContent(greeting, categories) {
                context.showToast(it)
            }
        }
    }

    companion object {
        fun start(activityContext: Context) {
            activityContext.startActivity(Intent(activityContext, ShoppingCategoryActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }
    }

}

@Composable
fun ShoppingContent(greeting: String, categories: List<Category>, onItemClick: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        Text(
            text = greeting,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.e_shop_by_categories),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            items(categories) {
                CategoryItem(it, onItemClick)
            }
        }
    }
}

@Composable
fun CategoryItem(category: Category, onItemClick: (String) -> Unit) {
    Column(
        modifier = Modifier.clickable { onItemClick(category.name) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(category.icon),
            contentScale = ContentScale.Fit,
            contentDescription = category.name,
            modifier = Modifier.width(96.dp).height(96.dp)
        )
        Text(text = category.name)
    }

}

@Preview(showBackground = true)
@Composable
private fun ShoppingContentPreview() {
    ShoppingContent(
        greeting = "Welcome back, HTran",
        categories = CATEGORIES
    ) {}
}

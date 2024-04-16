package miu.mdp.assignment5.cart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import miu.mdp.assignment5.R
import miu.mdp.assignment5.cart.data.Product
import miu.mdp.assignment5.cart.data.ProductRepository
import miu.mdp.assignment5.cart.data.ProductRepositoryImpl
import miu.mdp.assignment5.databinding.ActivityProductBinding
import miu.mdp.core.BaseActivity
import miu.mdp.core.showToast

class ProductActivity : BaseActivity<ActivityProductBinding>() {

    private val productRepository: ProductRepository = ProductRepositoryImpl()
    private lateinit var productAdapter: ProductAdapter
    private val cart: MutableList<Product> = mutableListOf()

    override fun initializeBinding(inflater: LayoutInflater) = ActivityProductBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupRecyclerView()
        setupViews()
        populateData()
    }

    private fun populateData() {
        MainScope().launch {
            val products = productRepository.getProducts()
            productAdapter.submitList(products)
        }
    }

    private fun setupViews() {
        binding.viewCartButton.setOnClickListener { viewCart() }
    }

    private fun setupRecyclerView() {
        productAdapter = ProductAdapter(
            onItemClick = {
                viewProductDetails(it)
            }, onAddToCartClick = {
                showToast("Added ${it.productName} to cart")
                cart.add(it)
            }
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = productAdapter
    }

    private fun viewProductDetails(product: Product) {
        ProductDetailsActivity.start(this, product)
    }

    private fun viewCart() {
        if (cart.isEmpty()) {
            showToast(getString(R.string.cart_is_empty))
        } else {
            showToast(cart.joinToString(separator = "\n") { it.productName })
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

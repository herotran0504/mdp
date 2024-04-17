package miu.mdp.assignment5.cart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import miu.mdp.assignment5.cart.model.Product
import miu.mdp.assignment5.databinding.ActivityProductDetailsBinding
import miu.mdp.core.BaseActivity

internal class ProductDetailsActivity : BaseActivity<ActivityProductDetailsBinding>() {

    override fun initializeBinding(inflater: LayoutInflater) = ActivityProductDetailsBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViews()
    }

    private fun setupViews() {
        val productImage = intent.getIntExtra(EXTRA_PRODUCT_IMAGE, 0)
        val productName = intent.getStringExtra(EXTRA_PRODUCT_NAME)
        val productDescription = intent.getStringExtra(EXTRA_PRODUCT_DESCRIPTION)
        val productCost = intent.getDoubleExtra(EXTRA_PRODUCT_COST, 0.0)

        binding.productImage.setImageResource(productImage)
        binding.productName.text = productName
        binding.productDescription.text = productDescription
        binding.productCost.text = "$${productCost}"
        binding.home.setOnClickListener { finish() }
    }

    companion object {
        private const val EXTRA_PRODUCT_IMAGE = "EXTRA_PRODUCT_IMAGE"
        private const val EXTRA_PRODUCT_LOGO = "EXTRA_PRODUCT_LOGO"
        private const val EXTRA_PRODUCT_NAME = "EXTRA_PRODUCT_NAME"
        private const val EXTRA_PRODUCT_DESCRIPTION = "EXTRA_PRODUCT_DESCRIPTION"
        private const val EXTRA_PRODUCT_COST = "EXTRA_PRODUCT_COST"

        fun start(activityContext: Context, product: Product) {
            activityContext.startActivity(Intent(activityContext, ProductDetailsActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                putExtra(EXTRA_PRODUCT_IMAGE, product.productImage)
                putExtra(EXTRA_PRODUCT_LOGO, product.productLogo)
                putExtra(EXTRA_PRODUCT_NAME, product.productName)
                putExtra(EXTRA_PRODUCT_DESCRIPTION, product.productDescription)
                putExtra(EXTRA_PRODUCT_COST, product.productCost)
            })
        }
    }
}

package miu.mdp.assignment4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import miu.mdp.assignment4.data.Category
import miu.mdp.assignment4.data.CategoryRepository
import miu.mdp.assignment4.data.UserState
import miu.mdp.assignment4.databinding.ActivityShoppingCategoryBinding
import miu.mdp.core.BindingActivity
import miu.mdp.core.showToast

class ShoppingCategoryActivity : BindingActivity<ActivityShoppingCategoryBinding>() {

    private val categoryRepository = CategoryRepository.get()

    override fun initializeBinding(inflater: LayoutInflater) = ActivityShoppingCategoryBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.welcome.text = getString(R.string.e_welcome, UserState.currentUser?.name.orEmpty())
        displayCategories(categoryRepository.getCategories())
    }

    private fun displayCategories(categories: List<Category>) {
        binding.categories.adapter = CategoryAdapter(categories) {
            showToast(it.name)
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


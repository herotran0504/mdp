package miu.mdp.assignment4.data

import androidx.annotation.DrawableRes
import miu.mdp.assignment4.R

data class Category(@DrawableRes val icon: Int, val name: String)

class CategoryRepository private constructor() {

    fun getCategories() = CATEGORIES

    companion object {
        private val CATEGORIES = listOf(
            Category(R.drawable.ic_kitchen, "Home and Kitchen"),
            Category(R.drawable.ic_nail, "Beauty and personal care"),
            Category(R.drawable.ic_pet_food, "Pet supplies"),
            Category(R.drawable.ic_puzzle, "Toys and games"),
        )

        fun get() = CategoryRepository()
    }

}
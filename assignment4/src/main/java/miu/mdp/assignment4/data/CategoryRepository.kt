package miu.mdp.assignment4.data

import miu.mdp.assignment4.R
import miu.mdp.assignment4.model.Category
import javax.inject.Inject

interface CategoryRepository {
    fun getCategories(): List<Category>
}

internal class CategoryRepositoryImpl @Inject constructor() : CategoryRepository {

    override fun getCategories() = CATEGORIES

    companion object {
        private val CATEGORIES = listOf(
            Category(R.drawable.ic_kitchen, "Home and Kitchen"),
            Category(R.drawable.ic_nail, "Beauty and personal care"),
            Category(R.drawable.ic_pet_food, "Pet supplies"),
            Category(R.drawable.ic_puzzle, "Toys and games"),
        )
    }

}
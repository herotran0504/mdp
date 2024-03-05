package miu.mdp.assignment4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import miu.mdp.assignment4.data.Category
import miu.mdp.assignment4.databinding.ItemCategoryBinding

class CategoryAdapter(
    private val categories: List<Category>,
    private val callback: (Category) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return ViewHolder(
            binding = ItemCategoryBinding.inflate(layoutInflater, viewGroup, false),
            callback = callback
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindData(categories[position])
    }

    override fun getItemCount() = categories.size

}

class ViewHolder(
    private val binding: ItemCategoryBinding,
    val callback: (Category) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(data: Category) {
        binding.icon.setImageResource(data.icon)
        binding.name.text = data.name
        binding.root.setOnClickListener { callback(data) }
    }
}


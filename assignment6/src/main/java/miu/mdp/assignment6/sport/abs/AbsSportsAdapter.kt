package miu.mdp.assignment6.sport.abs

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class AbsSportsAdapter<in T, B : ViewBinding>(
    private val items: List<T>
) : RecyclerView.Adapter<AbsSportsAdapter.ViewHolder<B>>() {

    abstract fun initializeBinding(parent: ViewGroup, viewType: Int): B

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<B> {
        return ViewHolder(initializeBinding(parent, viewType))
    }

    override fun onBindViewHolder(holder: ViewHolder<B>, position: Int) {
        val item = items[position]
        bindItem(item, holder)
    }

    override fun getItemCount() = items.size

    abstract fun bindItem(item: T, holder: ViewHolder<B>)

    class ViewHolder<out Binding : ViewBinding>(val binding: Binding) : RecyclerView.ViewHolder(binding.root)
}

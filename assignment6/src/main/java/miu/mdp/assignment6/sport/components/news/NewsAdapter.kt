package miu.mdp.assignment6.sport.components.news

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import miu.mdp.assignment6.databinding.ItemNewsBinding
import miu.mdp.assignment6.sport.abs.AbsSportsAdapter
import miu.mdp.assignment6.sport.model.News

class NewsAdapter(news: List<News>) : AbsSportsAdapter<News, ItemNewsBinding>(news) {

    override fun initializeBinding(parent: ViewGroup, viewType: Int) = ItemNewsBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )

    override fun bindItem(item: News, holder: ViewHolder<ItemNewsBinding>) {
        holder.binding.title.text = item.title
        holder.binding.description.text = item.description

        Glide
            .with(holder.itemView.context)
            .load(item.image)
            .fitCenter()
            .into(holder.binding.image)
    }

}

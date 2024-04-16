package miu.mdp.assignment6.sport.components.historical

import android.view.LayoutInflater
import android.view.ViewGroup
import miu.mdp.assignment6.databinding.ItemHistoricalBinding
import miu.mdp.assignment6.sport.abs.AbsSportsAdapter
import miu.mdp.assignment6.sport.model.Historical
import miu.mdp.core.formatToReadableString

class HistoricalSportsArchiveAdapter(
    historicalList: List<Historical>
) : AbsSportsAdapter<Historical, ItemHistoricalBinding>(historicalList) {

    override fun initializeBinding(parent: ViewGroup, viewType: Int) = ItemHistoricalBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )

    override fun bindItem(item: Historical, holder: ViewHolder<ItemHistoricalBinding>) {
        holder.binding.apply {
            name.text = item.name
            description.text = item.description
            date.text = item.date.formatToReadableString()
        }
    }

}

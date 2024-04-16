package miu.mdp.assignment6.sport.components.sports

import android.view.LayoutInflater
import android.view.ViewGroup
import miu.mdp.assignment6.databinding.ItemSportBinding
import miu.mdp.assignment6.sport.abs.AbsSportsAdapter
import miu.mdp.assignment6.sport.model.Sport

class SportsAdapter(sports: List<Sport>) : AbsSportsAdapter<Sport, ItemSportBinding>(sports) {

    override fun initializeBinding(parent: ViewGroup, viewType: Int) = ItemSportBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )

    override fun bindItem(item: Sport, holder: ViewHolder<ItemSportBinding>) {
        holder.binding.apply {
            type.text = item.type.name
            name.text = item.name
            instruction.text = item.instruction
        }
    }

}

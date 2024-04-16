package miu.mdp.assignment6.sport.components.athletes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import miu.mdp.assignment6.databinding.ItemAthletesBinding
import miu.mdp.assignment6.sport.abs.AbsSportsAdapter
import miu.mdp.assignment6.sport.model.Athlete

class AthletesAdapter(events: List<Athlete>) : AbsSportsAdapter<Athlete, ItemAthletesBinding>(events) {

    override fun initializeBinding(parent: ViewGroup, viewType: Int) = ItemAthletesBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )

    @SuppressLint("SetTextI18n")
    override fun bindItem(item: Athlete, holder: ViewHolder<ItemAthletesBinding>) {
        holder.binding.apply {
            name.text = "Name: ${item.name}"
            sport.text = "Sport: ${item.sport}"
            country.text = "Country: ${item.country}"
            bestPerformance.text = "Best performance: ${item.bestPerformance}"
            medals.text = "Medals: ${item.medals}"
            facts.text = "Fact: ${item.facts}"
        }
    }

}

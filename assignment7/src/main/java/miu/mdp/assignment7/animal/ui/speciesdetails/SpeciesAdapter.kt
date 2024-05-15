package miu.mdp.assignment7.animal.ui.speciesdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import miu.mdp.assignment7.animal.model.Species
import miu.mdp.assignment7.databinding.ItemAnimalBinding

internal class SpeciesAdapter : ListAdapter<Species, SpeciesViewHolder>(SpeciesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeciesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAnimalBinding.inflate(inflater, parent, false)
        return SpeciesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpeciesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

internal class SpeciesViewHolder(
    private val binding: ItemAnimalBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: Species) {
        binding.name.text = user.name
        binding.diet.text = user.description
    }
}

internal class SpeciesDiffCallback : DiffUtil.ItemCallback<Species>() {

    override fun areItemsTheSame(
        oldItem: Species,
        newItem: Species
    ) = oldItem.name == newItem.name &&
            oldItem.description == newItem.description

    override fun areContentsTheSame(
        oldItem: Species,
        newItem: Species
    ) = oldItem == newItem

}

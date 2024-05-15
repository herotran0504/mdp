package miu.mdp.assignment7.animal.ui.animaldetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import miu.mdp.assignment7.animal.model.Animal
import miu.mdp.assignment7.databinding.ItemAnimalBinding

internal class AnimalAdapter : ListAdapter<Animal, AnimalViewHolder>(AnimalDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAnimalBinding.inflate(inflater, parent, false)
        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

internal class AnimalViewHolder(
    private val binding: ItemAnimalBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: Animal) {
        binding.name.text = user.name
        binding.habitat.text = user.habitat
        binding.diet.text = user.diet
    }
}

internal class AnimalDiffCallback : DiffUtil.ItemCallback<Animal>() {

    override fun areItemsTheSame(
        oldItem: Animal,
        newItem: Animal
    ) = oldItem.name == newItem.name &&
            oldItem.diet == newItem.diet &&
            oldItem.habitat == newItem.habitat

    override fun areContentsTheSame(
        oldItem: Animal,
        newItem: Animal
    ) = oldItem == newItem

}

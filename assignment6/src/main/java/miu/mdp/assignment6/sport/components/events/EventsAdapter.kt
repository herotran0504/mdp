package miu.mdp.assignment6.sport.components.events

import android.view.LayoutInflater
import android.view.ViewGroup
import miu.mdp.assignment6.databinding.ItemEventsBinding
import miu.mdp.assignment6.sport.abs.AbsSportsAdapter
import miu.mdp.assignment6.sport.model.Event
import miu.mdp.core.formatToString

class EventsAdapter(events: List<Event>) : AbsSportsAdapter<Event, ItemEventsBinding>(events) {

    override fun initializeBinding(parent: ViewGroup, viewType: Int) = ItemEventsBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )

    override fun bindItem(item: Event, holder: ViewHolder<ItemEventsBinding>) {
        holder.binding.apply {
            name.text = item.name
            description.text = item.description
            date.text = item.date.formatToString()
        }
    }

}
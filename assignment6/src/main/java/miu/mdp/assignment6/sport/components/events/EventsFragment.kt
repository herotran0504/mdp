package miu.mdp.assignment6.sport.components.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import miu.mdp.assignment6.databinding.FragmentEventsBinding
import miu.mdp.assignment6.sport.abs.AbsSportFragment
import miu.mdp.assignment6.sport.data.EventsRepository

class EventsFragment : AbsSportFragment<FragmentEventsBinding>() {
    private val repository = EventsRepository()

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentEventsBinding.inflate(inflater, container, false)

    override fun display() {
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = EventsAdapter(repository.get())
    }

    override fun add() {
        AddEventsDialogFragment.show(childFragmentManager) {
            repository.add(it)
            binding.recyclerView.adapter?.notifyDataSetChanged()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.addBtn.setOnClickListener {
            add()
        }
    }
}


package miu.mdp.assignment6.sport.components.historical

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import miu.mdp.assignment6.databinding.FragmentHistoricalSportsArchiveBinding
import miu.mdp.assignment6.sport.abs.AbsSportFragment
import miu.mdp.assignment6.sport.data.HistoricalRepository

class HistoricalSportsArchiveFragment : AbsSportFragment<FragmentHistoricalSportsArchiveBinding>() {
    private val repository = HistoricalRepository()

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHistoricalSportsArchiveBinding.inflate(inflater, container, false)

    override fun display() {
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = HistoricalSportsArchiveAdapter(repository.get())
    }

    override fun add() {
        AddHistoricalDialogFragment.show(childFragmentManager) {
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


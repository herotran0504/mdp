package miu.mdp.assignment6.sport.components.athletes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import miu.mdp.assignment6.databinding.FragmentAthletesBinding
import miu.mdp.assignment6.sport.abs.AbsSportFragment
import miu.mdp.assignment6.sport.data.AthletesRepository
import javax.inject.Inject

@AndroidEntryPoint
class AthletesFragment : AbsSportFragment<FragmentAthletesBinding>() {

    @Inject
    lateinit var repository: AthletesRepository

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAthletesBinding.inflate(inflater, container, false)

    override fun display() {
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = AthletesAdapter(repository.get())
    }

    override fun add() {
        AddAthletesDialogFragment.show(childFragmentManager) {
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


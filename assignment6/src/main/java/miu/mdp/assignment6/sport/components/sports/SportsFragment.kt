package miu.mdp.assignment6.sport.components.sports

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import miu.mdp.assignment6.databinding.FragmentSportsBinding
import miu.mdp.assignment6.sport.abs.AbsSportFragment
import miu.mdp.assignment6.sport.data.SportsRepository
import javax.inject.Inject

@AndroidEntryPoint
class SportsFragment : AbsSportFragment<FragmentSportsBinding>() {

    @Inject
    lateinit var sportsRepository: SportsRepository

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSportsBinding.inflate(inflater, container, false)

    override fun display() {
        binding.recyclerView.layoutManager = GridLayoutManager(activity, 2)
        binding.recyclerView.adapter = SportsAdapter(sportsRepository.get())
    }

    override fun add() {
        AddSportDialogFragment.show(childFragmentManager) {
            sportsRepository.add(it)
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

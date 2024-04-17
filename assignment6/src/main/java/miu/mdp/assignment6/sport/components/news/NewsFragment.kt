package miu.mdp.assignment6.sport.components.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import miu.mdp.assignment6.databinding.FragmentNewsBinding
import miu.mdp.assignment6.sport.abs.AbsSportFragment
import miu.mdp.assignment6.sport.data.NewsRepository
import javax.inject.Inject

@AndroidEntryPoint
class NewsFragment : AbsSportFragment<FragmentNewsBinding>() {

    @Inject
    lateinit var repository: NewsRepository

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentNewsBinding.inflate(inflater, container, false)

    override fun display() {
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = NewsAdapter(repository.get())
    }

    override fun add() {
        AddNewsDialogFragment.show(childFragmentManager) {
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

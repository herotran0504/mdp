package miu.mdp.assignment7.animal.ui.speciesdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import miu.mdp.assignment7.R
import miu.mdp.assignment7.animal.AnimalKingdomActivity
import miu.mdp.assignment7.animal.data.Result.Error
import miu.mdp.assignment7.animal.data.Result.Success
import miu.mdp.assignment7.animal.ui.addspecies.AddSpeciesDialogFragment
import miu.mdp.assignment7.databinding.FragmentSpeciesBinding
import miu.mdp.core.BaseFragment
import miu.mdp.core.showToast

@AndroidEntryPoint
internal class SpeciesDetailsFragment : BaseFragment<FragmentSpeciesBinding>() {

    private val viewModel: SpeciesViewModel by viewModels()
    private lateinit var adapter: SpeciesAdapter

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSpeciesBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEvents()
        setupToolbar()
        setupViews()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = SpeciesAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
    }

    private fun setupViews() {
        binding.addBtn.setOnClickListener {
            AddSpeciesDialogFragment.show(childFragmentManager) {
                viewModel.insertSpecies(it)
            }
        }
    }

    private fun setupToolbar() {
        (requireActivity() as AnimalKingdomActivity).getToolbar().apply {
            title = context.getString(R.string.k_species_details)
            setNavigationIcon(R.drawable.ic_arrow_back)
            setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun observeEvents() {
        viewModel.fetchResult.observe(viewLifecycleOwner) {
            when (it) {
                is Success -> adapter.submitList(it.data)
                is Error -> showToast("Error: ${it.throwable.message}")
            }
        }

        viewModel.insertResult.observe(viewLifecycleOwner) {
            when (it) {
                is Success -> showToast("New species added")
                is Error -> showToast("Error: ${it.throwable.message}")
            }
        }
    }
}

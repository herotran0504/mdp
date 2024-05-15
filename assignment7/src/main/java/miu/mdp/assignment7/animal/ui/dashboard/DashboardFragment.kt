package miu.mdp.assignment7.animal.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import miu.mdp.assignment7.R
import miu.mdp.assignment7.animal.AnimalKingdomActivity
import miu.mdp.assignment7.databinding.FragmentDashboardBinding
import miu.mdp.core.BaseFragment

internal class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDashboardBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.animalDetails.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_animalFragment)
        }

        binding.speciesDetails.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_speciesFragment)
        }

    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as AnimalKingdomActivity).getToolbar().apply {
            title = context.getString(R.string.k_title_home)
            setNavigationIcon(null)
        }
    }

}

package miu.mdp.assignment6.sport.components.athletes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import miu.mdp.assignment6.databinding.DialogAddAthletesBinding
import miu.mdp.assignment6.sport.model.Athlete
import miu.mdp.core.BaseDialogFragment
import miu.mdp.core.showToast

class AddAthletesDialogFragment : BaseDialogFragment<DialogAddAthletesBinding>() {

    private lateinit var callback: (Athlete) -> Unit

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = DialogAddAthletesBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addBtn.setOnClickListener {
            val name = binding.name.text.toString()
            val sport = binding.sport.text.toString()
            val country = binding.country.text.toString()
            val bestPerformance = binding.bestPerformance.text.toString()
            val medals = binding.medals.text.toString()
            val facts = binding.facts.text.toString()

            if (validateInput(name, sport, country, bestPerformance, medals, facts)) {
                callback(Athlete(name, sport, country, bestPerformance, medals.toIntOrNull() ?: 0, facts))
                dismissAllowingStateLoss()
            } else {
                activity?.showToast("Please input valid data")
            }
        }
        binding.cancelBtn.setOnClickListener {
            dismissAllowingStateLoss()
        }
    }

    private fun validateInput(
        name: String,
        sport: String,
        country: String,
        bestPerformance: String,
        medals: String,
        facts: String
    ) = !(name.isBlank() || sport.isBlank() || country.isBlank() || bestPerformance.isBlank() || medals.isBlank() || facts.isBlank())

    companion object {
        fun show(fragmentManager: FragmentManager, callback: (Athlete) -> Unit = {}) {
            val dialogFragment = AddAthletesDialogFragment()
            dialogFragment.callback = callback
            dialogFragment.show(fragmentManager, AddAthletesDialogFragment::class.java.simpleName)
        }
    }
}

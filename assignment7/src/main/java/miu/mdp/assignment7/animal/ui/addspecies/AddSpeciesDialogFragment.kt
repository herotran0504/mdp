package miu.mdp.assignment7.animal.ui.addspecies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import miu.mdp.assignment7.animal.model.Species
import miu.mdp.assignment7.databinding.DialogAddSpeciesBinding
import miu.mdp.core.BaseDialogFragment
import miu.mdp.core.showToast

class AddSpeciesDialogFragment : BaseDialogFragment<DialogAddSpeciesBinding>() {

    private lateinit var callback: (Species) -> Unit

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = DialogAddSpeciesBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addBtn.setOnClickListener {
            val name = binding.name.text.toString()
            val description = binding.description.text.toString()

            if (validateInput(name = name, description = description)) {
                callback(Species(name = name, description = description))
                dismissAllowingStateLoss()
            } else {
                activity?.showToast("Please input valid data")
            }
        }

        binding.cancelBtn.setOnClickListener {
            dismissAllowingStateLoss()
        }
    }

    private fun validateInput(name: String, description: String): Boolean {
        return !(name.isBlank() || description.isBlank())
    }

    companion object {
        fun show(fragmentManager: FragmentManager, callback: (Species) -> Unit = {}) {
            val dialogFragment = AddSpeciesDialogFragment()
            dialogFragment.callback = callback
            dialogFragment.show(fragmentManager, AddSpeciesDialogFragment::class.java.simpleName)
        }
    }
}

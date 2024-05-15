package miu.mdp.assignment7.animal.ui.addanimal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import miu.mdp.assignment7.animal.model.Animal
import miu.mdp.assignment7.databinding.DialogAddAnimalBinding
import miu.mdp.core.BaseDialogFragment
import miu.mdp.core.showToast

class AddAnimalDialogFragment : BaseDialogFragment<DialogAddAnimalBinding>() {

    private lateinit var callback: (Animal) -> Unit

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = DialogAddAnimalBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addBtn.setOnClickListener {
            val name = binding.name.text.toString()
            val habitat = binding.habitat.text.toString()
            val diet = binding.diet.text.toString()

            if (validateInput(name = name, habitat = habitat, diet = diet)) {
                callback(Animal(name, habitat, diet))
                dismissAllowingStateLoss()
            } else {
                activity?.showToast("Please input valid data")
            }
        }

        binding.cancelBtn.setOnClickListener {
            dismissAllowingStateLoss()
        }
    }

    private fun validateInput(name: String, habitat: String, diet: String): Boolean {
        return !(name.isBlank() || habitat.isBlank() || diet.isBlank())
    }

    companion object {
        fun show(fragmentManager: FragmentManager, callback: (Animal) -> Unit = {}) {
            val dialogFragment = AddAnimalDialogFragment()
            dialogFragment.callback = callback
            dialogFragment.show(fragmentManager, AddAnimalDialogFragment::class.java.simpleName)
        }
    }
}

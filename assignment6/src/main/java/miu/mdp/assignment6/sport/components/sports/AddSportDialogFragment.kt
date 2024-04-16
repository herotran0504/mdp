package miu.mdp.assignment6.sport.components.sports

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.FragmentManager
import miu.mdp.assignment6.databinding.DialogAddSportBinding
import miu.mdp.assignment6.sport.model.Sport
import miu.mdp.assignment6.sport.model.SportType
import miu.mdp.core.BaseDialogFragment

class AddSportDialogFragment : BaseDialogFragment<DialogAddSportBinding>() {

    internal lateinit var callback: (Sport) -> Unit

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = DialogAddSportBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addBtn.setOnClickListener {
            val name = binding.sportNameEditText.text.toString()
            val type = binding.sportTypeSpinner.selectedItem.toString()
            val instruction = binding.sportInstructionEditText.text.toString()

            if (validateInput(name, type, instruction)) {
                val newSport = Sport(SportType.valueOf(type), name, instruction)
                callback(newSport)
                dismissAllowingStateLoss()
            }
        }
        binding.cancelBtn.setOnClickListener {
            dismissAllowingStateLoss()
        }
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, SportType.entries.toTypedArray())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.sportTypeSpinner.adapter = adapter
    }

    private fun validateInput(name: String, type: String, instruction: String): Boolean {
        return !(name.isBlank() || type.isBlank() || instruction.isBlank())
    }

    companion object {
        fun show(fragmentManager: FragmentManager, callback: (Sport) -> Unit = {}) {
            val dialogFragment = AddSportDialogFragment()
            dialogFragment.callback = callback
            dialogFragment.show(fragmentManager, AddSportDialogFragment::class.java.simpleName)
        }
    }
}

package miu.mdp.assignment6.sport.components.historical

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import miu.mdp.assignment6.databinding.DialogAddHistoricalsBinding
import miu.mdp.assignment6.sport.model.Historical
import miu.mdp.core.*
import java.util.*

class AddHistoricalDialogFragment : BaseDialogFragment<DialogAddHistoricalsBinding>() {

    private lateinit var callback: (Historical) -> Unit

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = DialogAddHistoricalsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addBtn.setOnClickListener {
            val name = binding.name.text.toString()
            val date = binding.date.text.toString()
            val description = binding.description.text.toString()

            if (validateInput(name, date, description)) {
                callback(Historical(name, description, date.parseToDate()))
                dismissAllowingStateLoss()
            } else {
                activity?.showToast("Please input valid data")
            }
        }

        binding.date.setOnClickListener {
            showDatePicker()
        }

        binding.cancelBtn.setOnClickListener {
            dismissAllowingStateLoss()
        }
    }

    private fun showDatePicker() {
        showBackwardDatePicker(childFragmentManager) {
            binding.date.setText(Date(it).formatToString())
        }
    }

    private fun validateInput(name: String, date: String, description: String): Boolean {
        return !(name.isBlank() || date.isBlank() || description.isBlank())
    }

    companion object {
        fun show(fragmentManager: FragmentManager, callback: (Historical) -> Unit = {}) {
            val dialogFragment = AddHistoricalDialogFragment()
            dialogFragment.callback = callback
            dialogFragment.show(fragmentManager, AddHistoricalDialogFragment::class.java.simpleName)
        }
    }
}

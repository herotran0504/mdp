package miu.mdp.assignment6.sport.components.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import miu.mdp.assignment6.databinding.DialogAddEventsBinding
import miu.mdp.assignment6.sport.model.Event
import miu.mdp.core.*
import java.util.*

class AddEventsDialogFragment : BaseDialogFragment<DialogAddEventsBinding>() {

    private lateinit var callback: (Event) -> Unit
    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = DialogAddEventsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addBtn.setOnClickListener {
            val name = binding.name.text.toString()
            val date = binding.date.text.toString()
            val description = binding.description.text.toString()

            if (validateInput(name, date, description)) {
                callback(Event(name, description, date.parseToDate()))
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
        showForwardDatePicker(childFragmentManager) {
            binding.date.setText(Date(it).formatToString())
        }
    }

    private fun validateInput(name: String, date: String, description: String): Boolean {
        return !(name.isBlank() || date.isBlank() || description.isBlank())
    }

    companion object {
        fun show(fragmentManager: FragmentManager, callback: (Event) -> Unit = {}) {
            val dialogFragment = AddEventsDialogFragment()
            dialogFragment.callback = callback
            dialogFragment.show(fragmentManager, AddEventsDialogFragment::class.java.simpleName)
        }
    }
}

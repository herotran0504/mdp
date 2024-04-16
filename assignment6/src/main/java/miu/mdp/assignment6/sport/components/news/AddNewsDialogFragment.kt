package miu.mdp.assignment6.sport.components.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import miu.mdp.assignment6.databinding.DialogAddNewsBinding
import miu.mdp.assignment6.sport.model.News
import miu.mdp.core.BaseDialogFragment
import miu.mdp.core.showToast

class AddNewsDialogFragment : BaseDialogFragment<DialogAddNewsBinding>() {

    private lateinit var callback: (News) -> Unit

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = DialogAddNewsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addBtn.setOnClickListener {
            val imageUrl = binding.imageUrl.text.toString()
            val title = binding.title.text.toString()
            val description = binding.description.text.toString()

            if (validateInput(imageUrl, title, description)) {
                callback(News(title = title, description = description, image = imageUrl))
                dismissAllowingStateLoss()
            } else {
                activity?.showToast("Please input valid data")
            }
        }
        binding.cancelBtn.setOnClickListener {
            dismissAllowingStateLoss()
        }
    }

    private fun validateInput(name: String, type: String, instruction: String): Boolean {
        return !(name.isBlank() || type.isBlank() || instruction.isBlank())
    }

    companion object {
        fun show(fragmentManager: FragmentManager, callback: (News) -> Unit = {}) {
            val dialogFragment = AddNewsDialogFragment()
            dialogFragment.callback = callback
            dialogFragment.show(fragmentManager, AddNewsDialogFragment::class.java.simpleName)
        }
    }
}

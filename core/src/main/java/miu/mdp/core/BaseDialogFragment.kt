package miu.mdp.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

abstract class BaseDialogFragment<out Binding : ViewBinding> : DialogFragment() {

    private var _binding: Binding? = null

    protected val binding get() = _binding!!

    abstract fun initializeBinding(inflater: LayoutInflater, container: ViewGroup?): Binding

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = initializeBinding(inflater, container)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setFitParent()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}

fun DialogFragment.setFitParent(
    width: Int = LayoutParams.MATCH_PARENT,
    height: Int = LayoutParams.WRAP_CONTENT
) {
    dialog?.window?.setLayout(width, height)
}
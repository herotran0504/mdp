package miu.mdp.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<out Binding : ViewBinding> : Fragment() {

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

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}
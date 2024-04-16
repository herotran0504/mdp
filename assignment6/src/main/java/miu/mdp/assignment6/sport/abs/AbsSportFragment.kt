package miu.mdp.assignment6.sport.abs

import android.os.Bundle
import android.view.View
import androidx.viewbinding.ViewBinding
import miu.mdp.core.BaseFragment

abstract class AbsSportFragment<out Binding : ViewBinding> : BaseFragment<Binding>() {

    abstract fun display()

    abstract fun add()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        display()
    }
}
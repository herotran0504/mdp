package miu.mdp.core

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<out Binding : ViewBinding> : AppCompatActivity() {

    private var _binding: Binding? = null

    protected val binding get() = _binding!!

    abstract fun initializeBinding(inflater: LayoutInflater): Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = initializeBinding(layoutInflater)
        setContentView(binding.root)
    }

}

package miu.mdp.app

import android.os.Bundle
import android.view.LayoutInflater
import miu.mdp.app.nav.Nav
import miu.mdp.core.BindingActivity
import miu.mdp.databinding.ActivityMainBinding

class MainActivity : BindingActivity<ActivityMainBinding>() {

    override fun initializeBinding(inflater: LayoutInflater) = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.asm2.setOnClickListener { Nav.openAssignment2(this) }
        binding.asm31.setOnClickListener { Nav.openAssignment31(this) }
        binding.asm32.setOnClickListener { Nav.openAssignment32(this) }
        binding.asm4.setOnClickListener { Nav.openAssignment4(this) }
        binding.asm51.setOnClickListener { Nav.openAssignment51(this) }
        binding.asm52.setOnClickListener { Nav.openAssignment52(this) }
    }

}

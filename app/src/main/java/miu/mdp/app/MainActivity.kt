package miu.mdp.app

import android.os.Bundle
import android.view.LayoutInflater
import dagger.hilt.android.AndroidEntryPoint
import miu.mdp.app.nav.Nav
import miu.mdp.core.BaseActivity
import miu.mdp.core.hideSystemBar
import miu.mdp.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject
    lateinit var nav: Nav

    override fun initializeBinding(inflater: LayoutInflater) = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemBar()
        initViews()
    }

    private fun initViews() {
        binding.asm2.setOnClickListener { nav.openAssignment2(this) }
        binding.asm31.setOnClickListener { nav.openAssignment31(this) }
        binding.asm32.setOnClickListener { nav.openAssignment32(this) }
        binding.asm4.setOnClickListener { nav.openAssignment4(this) }
        binding.asm51.setOnClickListener { nav.openAssignment51(this) }
        binding.asm52.setOnClickListener { nav.openAssignment52(this) }
        binding.asm6.setOnClickListener { nav.openAssignment6(this) }
    }

}

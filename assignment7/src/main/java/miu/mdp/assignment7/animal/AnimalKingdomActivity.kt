package miu.mdp.assignment7.animal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import miu.mdp.assignment7.R
import miu.mdp.assignment7.databinding.ActivityAnimalKingdomBinding
import miu.mdp.core.BaseActivity

@AndroidEntryPoint
class AnimalKingdomActivity : BaseActivity<ActivityAnimalKingdomBinding>() {

    private lateinit var navController: NavController

    private lateinit var toolbar: Toolbar

    override fun initializeBinding(
        inflater: LayoutInflater
    ) = ActivityAnimalKingdomBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    fun getToolbar() = toolbar

    companion object {
        fun start(activityContext: Context) {
            activityContext.startActivity(Intent(activityContext, AnimalKingdomActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }
    }

}

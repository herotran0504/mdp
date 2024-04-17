package miu.mdp.assignment6.sport

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import miu.mdp.assignment6.R
import miu.mdp.assignment6.databinding.ActivitySportsBinding
import miu.mdp.core.BaseActivity

@AndroidEntryPoint
class SportsActivity : BaseActivity<ActivitySportsBinding>() {

    override fun initializeBinding(inflater: LayoutInflater) = ActivitySportsBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.viewPager.setAdapter(SportsPagerAdapter(supportFragmentManager))
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        handleViewPagerEvent()
        handleBottomNavigationEvent()
    }

    private fun handleBottomNavigationEvent() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item_news -> binding.viewPager.setCurrentItem(PAGER_INDEX_NEWS, true)
                R.id.item_events -> binding.viewPager.setCurrentItem(PAGER_INDEX_EVENTS, true)
                R.id.item_historical -> binding.viewPager.setCurrentItem(PAGER_INDEX_HISTORICAL, true)
            }
            true
        }
    }

    private fun handleViewPagerEvent() {
        binding.viewPager.setCurrentItem(PAGER_INDEX_NEWS, true)
        binding.viewPager.addOnPageChangeListener(object : SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    PAGER_INDEX_NEWS -> enableMenuItem(BOTTOM_BAR_INDEX_NEWS)
                    PAGER_INDEX_EVENTS -> enableMenuItem(BOTTOM_BAR_INDEX_EVENTS)
                    PAGER_INDEX_HISTORICAL -> enableMenuItem(BOTTOM_BAR_INDEX_HISTORICAL)
                    else -> binding.bottomNavigation.uncheckAllItems()
                }
            }

            private fun enableMenuItem(@BottomBarIndex index: Int) {
                binding.bottomNavigation.menu.getItem(index).isChecked = true
            }

        })
    }

    companion object {
        fun start(activityContext: Context) {
            activityContext.startActivity(Intent(activityContext, SportsActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }
    }

}

fun BottomNavigationView.uncheckAllItems() {
    menu.setGroupCheckable(0, true, false)
    for (i in 0 until menu.size()) {
        menu.getItem(i).isChecked = false
    }
    menu.setGroupCheckable(0, true, true)
}

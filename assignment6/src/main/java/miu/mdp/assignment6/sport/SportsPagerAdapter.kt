package miu.mdp.assignment6.sport

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import miu.mdp.assignment6.sport.components.about.AboutMeFragment
import miu.mdp.assignment6.sport.components.athletes.AthletesFragment
import miu.mdp.assignment6.sport.components.events.EventsFragment
import miu.mdp.assignment6.sport.components.historical.HistoricalSportsArchiveFragment
import miu.mdp.assignment6.sport.components.news.NewsFragment
import miu.mdp.assignment6.sport.components.sports.SportsFragment

// TODO migrate to ViewPager2
class SportsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int) = fragments[position]

    override fun getCount() = fragments.size

    override fun getPageTitle(position: Int) = pageTitle(position)

    private fun pageTitle(@PagerIndex index: Int) = when (index) {
        PAGER_INDEX_SPORTS -> "Sports"
        PAGER_INDEX_NEWS -> "News"
        PAGER_INDEX_ATHLETES -> "Athletes"
        PAGER_INDEX_EVENTS -> "Events"
        PAGER_INDEX_HISTORICAL -> "Historical Archives"
        PAGER_INDEX_ABOUT -> "About Me"
        else -> ""
    }

    companion object {

        private val fragments = listOf(
            SportsFragment(),
            NewsFragment(),
            AthletesFragment(),
            EventsFragment(),
            HistoricalSportsArchiveFragment(),
            AboutMeFragment()
        )

    }
}
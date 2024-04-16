package miu.mdp.assignment6.sport

import androidx.annotation.IntDef

internal const val PAGER_INDEX_SPORTS = 0
internal const val PAGER_INDEX_NEWS = 1
internal const val PAGER_INDEX_ATHLETES = 2
internal const val PAGER_INDEX_EVENTS = 3
internal const val PAGER_INDEX_HISTORICAL = 4
internal const val PAGER_INDEX_ABOUT = 5

@Retention(AnnotationRetention.SOURCE)
@IntDef(
    PAGER_INDEX_SPORTS,
    PAGER_INDEX_NEWS,
    PAGER_INDEX_ATHLETES,
    PAGER_INDEX_EVENTS,
    PAGER_INDEX_HISTORICAL,
    PAGER_INDEX_ABOUT
)
internal annotation class PagerIndex

internal const val BOTTOM_BAR_INDEX_NEWS = 0
internal const val BOTTOM_BAR_INDEX_EVENTS = 1
internal const val BOTTOM_BAR_INDEX_HISTORICAL = 2

@Retention(AnnotationRetention.SOURCE)
@IntDef(
    BOTTOM_BAR_INDEX_NEWS,
    BOTTOM_BAR_INDEX_EVENTS,
    BOTTOM_BAR_INDEX_HISTORICAL
)
internal annotation class BottomBarIndex
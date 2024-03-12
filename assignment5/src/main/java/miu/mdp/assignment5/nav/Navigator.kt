package miu.mdp.assignment5.nav

import android.content.Context
import miu.mdp.assignment5.survey.SurveyActivity

object Navigator {

    fun startSurveyScreen(activityContext: Context, isFoodSurvey: Boolean = true) {
        SurveyActivity.start(activityContext, isFoodSurvey)
    }

}
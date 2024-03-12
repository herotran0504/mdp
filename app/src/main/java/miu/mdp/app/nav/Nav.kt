package miu.mdp.app.nav

import android.content.Context
import miu.mdp.assignment2.ChemicalActivity
import miu.mdp.assignment3.AmazonLoginActivity
import miu.mdp.assignment3.WaterResourceActivity
import miu.mdp.assignment4.SignInActivity
import miu.mdp.assignment5.survey.MainActivity

object Nav {

    fun openAssignment2(activityContext: Context) {
        ChemicalActivity.start(activityContext)
    }

    fun openAssignment31(activityContext: Context) {
        WaterResourceActivity.start(activityContext)
    }

    fun openAssignment32(activityContext: Context) {
        AmazonLoginActivity.start(activityContext)
    }

    fun openAssignment4(activityContext: Context) {
        SignInActivity.start(activityContext)
    }

    fun openAssignment51(activityContext: Context) {
        MainActivity.start(activityContext)
    }

    fun openAssignment52(activityContext: Context) {

    }

}
package miu.mdp.app.nav

import android.content.Context
import miu.mdp.extra.ui.ProgramActivity
import miu.mdp.assignment2.ChemicalActivity
import miu.mdp.assignment3.AmazonLoginActivity
import miu.mdp.assignment3.WaterResourceActivity
import miu.mdp.assignment4.SignInActivity
import miu.mdp.assignment5.cart.ProductActivity
import miu.mdp.assignment5.survey.SurveyStarterActivity
import miu.mdp.assignment6.sport.SportsActivity
import miu.mdp.assignment7.animal.AnimalKingdomActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Nav @Inject constructor() {

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
        SurveyStarterActivity.start(activityContext)
    }

    fun openAssignment52(activityContext: Context) {
        ProductActivity.start(activityContext)
    }

    fun openAssignment6(activityContext: Context) {
        SportsActivity.start(activityContext)
    }

    fun openAssignment7(activityContext: Context) {
        AnimalKingdomActivity.start(activityContext)
    }

    fun openExtra(activityContext: Context) {
        ProgramActivity.start(activityContext)
    }
}

package miu.mdp.assignment4.nav

import android.content.Context
import miu.mdp.assignment4.CreateAccountActivity
import miu.mdp.assignment4.ShoppingCategoryActivity
import miu.mdp.assignment4.SignInActivity

object Navigator {

    fun openSignInScreen(activityContext: Context) {
        SignInActivity.start(activityContext = activityContext)
    }

    fun openCreateAccountScreen(activityContext: Context) {
        CreateAccountActivity.start(activityContext = activityContext)
    }

    fun openShoppingCategoryScreen(activityContext: Context) {
        ShoppingCategoryActivity.start(activityContext = activityContext)
    }
}
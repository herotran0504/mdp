package miu.mdp.assignment4.signin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dagger.hilt.android.AndroidEntryPoint
import miu.mdp.assignment4.createaccount.CreateAccountActivity
import miu.mdp.assignment4.R
import miu.mdp.assignment4.ShoppingCategoryActivity
import miu.mdp.assignment4.data.UserRepository
import miu.mdp.core.hideKeyboard
import miu.mdp.core.showToast
import javax.inject.Inject

@AndroidEntryPoint
class SignInActivity : ComponentActivity() {

    @Inject
    lateinit var repo: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    color = Color.White,
                    modifier = Modifier.fillMaxSize()
                ) {
                    SignInScreen(
                        onSignIn = { id, password -> validateUser(id, password) },
                        onCreateAccount = { CreateAccountActivity.start(activityContext = this) }
                    )
                }
            }
        }
    }

    private fun validateUser(id: String, password: String) {
        if (id.isEmpty()) {
            displayError(getString(R.string.e_email_error))
        } else if (password.isEmpty()) {
            displayError(getString(R.string.e_password_error))
        } else {
            val user = repo.validate(id, password)
            if (user == null) {
                displayError(getString(R.string.e_login_error))
            } else {
                ShoppingCategoryActivity.start(activityContext = this)
            }
        }
    }

    private fun displayError(message: String) {
        showToast(message)
        hideKeyboard()
    }

    companion object {
        fun start(activityContext: Context) {
            activityContext.startActivity(Intent(activityContext, SignInActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }
    }
}

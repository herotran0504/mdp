package miu.mdp.assignment4.createaccount

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dagger.hilt.android.AndroidEntryPoint
import miu.mdp.assignment4.R
import miu.mdp.assignment4.ShoppingCategoryActivity
import miu.mdp.assignment4.data.UserRepository
import miu.mdp.assignment4.model.User
import miu.mdp.core.hideKeyboard
import miu.mdp.core.showToast
import javax.inject.Inject

@AndroidEntryPoint
class CreateAccountActivity : ComponentActivity() {

    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize().background(Color.White)) {
                CreateAccountScreen { name, id, password, repeatPassword ->
                    when {
                        name.isEmpty() -> displayError(getString(R.string.e_name_error))
                        id.isEmpty() -> displayError(getString(R.string.e_email_error))
                        password.isEmpty() -> displayError(getString(R.string.e_password_error))
                        repeatPassword.isEmpty() -> displayError(getString(R.string.e_password_error))
                        repeatPassword != password -> displayError(getString(R.string.e_match_password_error))
                        else -> createAccount(name, id, password)
                    }
                }
            }
        }
    }

    private fun createAccount(name: String, id: String, password: String) {
        val user = userRepository.createAccount(User(name, id, password))
        if (user == null) {
            displayError(getString(R.string.e_user_is_existed))
        } else {
            ShoppingCategoryActivity.start(activityContext = this)
        }
    }

    private fun displayError(message: String) {
        showToast(message)
        hideKeyboard()
    }

    companion object {
        fun start(activityContext: Context) {
            activityContext.startActivity(Intent(activityContext, CreateAccountActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            })
        }
    }

}

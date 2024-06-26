package miu.mdp.assignment4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import dagger.hilt.android.AndroidEntryPoint
import miu.mdp.assignment4.data.UserRepository
import miu.mdp.assignment4.databinding.ActivitySigninBinding
import miu.mdp.core.BaseActivity
import miu.mdp.core.hideKeyboard
import miu.mdp.core.showToast
import javax.inject.Inject

@AndroidEntryPoint
class SignInActivity : BaseActivity<ActivitySigninBinding>() {

    @Inject
    lateinit var repo: UserRepository

    override fun initializeBinding(inflater: LayoutInflater) = ActivitySigninBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.showPassword.setOnCheckedChangeListener { _, isChecked -> handleShowPassword(isChecked) }
        binding.signInBtn.setOnClickListener { doLogin() }
        binding.createAccountBtn.setOnClickListener {
            CreateAccountActivity.start(activityContext = this)
        }
    }

    private fun handleShowPassword(show: Boolean) {
        if (show) {
            binding.password.transformationMethod = HideReturnsTransformationMethod.getInstance()
        } else {
            binding.password.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }

    private fun doLogin() {
        val id = binding.email.text.toString()
        val password = binding.password.text.toString()
        if (id.isEmpty()) {
            displayError(getString(R.string.e_email_error))
        } else if (password.isEmpty()) {
            displayError(getString(R.string.e_password_error))
        } else {
            validateUser(id, password)
        }
    }

    private fun validateUser(id: String, password: String) {
        val user = repo.validate(id, password)
        if (user == null) {
            displayError(getString(R.string.e_login_error))
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
            activityContext.startActivity(Intent(activityContext, SignInActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }
    }
}

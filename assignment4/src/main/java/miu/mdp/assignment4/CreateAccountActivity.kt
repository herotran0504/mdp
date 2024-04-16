package miu.mdp.assignment4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import miu.mdp.assignment4.data.User
import miu.mdp.assignment4.data.UserRepository
import miu.mdp.assignment4.databinding.ActivityCreateAccountBinding
import miu.mdp.core.BaseActivity
import miu.mdp.core.hideKeyboard
import miu.mdp.core.showToast

class CreateAccountActivity : BaseActivity<ActivityCreateAccountBinding>() {

    private val userRepository = UserRepository.get()

    override fun initializeBinding(inflater: LayoutInflater) = ActivityCreateAccountBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.createAccountBtn.setOnClickListener { createAccount() }
    }

    private fun createAccount() {
        val name = binding.name.text.toString()
        val id = binding.id.text.toString()
        val password = binding.password.text.toString()
        val rePassword = binding.rePassword.text.toString()
        when {
            name.isEmpty() -> displayError(getString(R.string.e_name_error))
            id.isEmpty() -> displayError(getString(R.string.e_email_error))
            password.isEmpty() -> displayError(getString(R.string.e_password_error))
            rePassword.isEmpty() -> displayError(getString(R.string.e_password_error))
            rePassword != password -> displayError(getString(R.string.e_match_password_error))
            else -> createAccount(name, id, password)
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
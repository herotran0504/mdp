package miu.mdp.assignment4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import miu.mdp.assignment4.databinding.ActivityCreateAccountBinding
import miu.mdp.core.BindingActivity

class CreateAccountActivity : BindingActivity<ActivityCreateAccountBinding>() {

    override fun initializeBinding(inflater: LayoutInflater) = ActivityCreateAccountBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {

    }

    fun createAccount() {

    }

    companion object {
        fun start(activityContext: Context) {
            activityContext.startActivity(Intent(activityContext, CreateAccountActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            })
        }
    }

}
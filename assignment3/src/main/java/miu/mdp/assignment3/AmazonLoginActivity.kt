package miu.mdp.assignment3

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import miu.mdp.assignment3.databinding.ActivityAmzLoginBinding
import miu.mdp.core.BaseActivity

class AmazonLoginActivity : BaseActivity<ActivityAmzLoginBinding>() {

    override fun initializeBinding(inflater: LayoutInflater) = ActivityAmzLoginBinding.inflate(layoutInflater)

    companion object {
        fun start(activityContext: Context) {
            activityContext.startActivity(Intent(activityContext, AmazonLoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }
    }
}

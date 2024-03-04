package miu.mdp.assignment3

import android.view.LayoutInflater
import miu.mdp.core.BindingActivity
import miu.mdp.databinding.ActivityAmzLoginBinding

class AmazonLoginActivity : BindingActivity<ActivityAmzLoginBinding>() {

    override fun initializeBinding(inflater: LayoutInflater) = ActivityAmzLoginBinding.inflate(layoutInflater)
}

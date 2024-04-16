package miu.mdp.assignment5.survey

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import miu.mdp.assignment5.databinding.ActivityStartBinding
import miu.mdp.assignment5.nav.Navigator
import miu.mdp.core.BaseActivity

class MainActivity : BaseActivity<ActivityStartBinding>() {

    override fun initializeBinding(inflater: LayoutInflater) = ActivityStartBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.startBtn.setOnClickListener {
            Navigator.startSurveyScreen(this, binding.selector.checkedRadioButtonId == binding.food.id)
        }
    }

    companion object {
        fun start(activityContext: Context) {
            activityContext.startActivity(Intent(activityContext, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }
    }
}

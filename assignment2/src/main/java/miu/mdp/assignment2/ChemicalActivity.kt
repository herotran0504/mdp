package miu.mdp.assignment2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import miu.mdp.assignment2.ui.ChemicalScreen
import miu.mdp.assignment2.ui.ChemicalViewModel

@AndroidEntryPoint
class ChemicalActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: ChemicalViewModel = hiltViewModel()
            ChemicalScreen(viewModel)
        }
    }

    companion object {
        fun start(activityContext: Context) {
            activityContext.startActivity(Intent(activityContext, ChemicalActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }
    }

}

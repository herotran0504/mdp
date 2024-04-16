package miu.mdp.assignment2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import miu.mdp.assignment2.databinding.ActivityChemicalBinding
import miu.mdp.core.BaseActivity
import miu.mdp.core.hideKeyboard
import miu.mdp.core.randElm

class ChemicalActivity : BaseActivity<ActivityChemicalBinding>() {

    private val chemicals = mutableListOf("Aluminum", "Gold", "Selenium")

    override fun initializeBinding(inflater: LayoutInflater) = ActivityChemicalBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.guessBtn.setOnClickListener {
            handleGuessChemical()
        }
        binding.addBtn.setOnClickListener {
            handleAddChemical()
        }
    }

    private fun handleGuessChemical() {
        val chemical = binding.guessInput.text.toString()
        if (chemical.isEmpty()) {
            displayMessage("Please input chemical to guess.")
        } else {
            val random = chemicals.randElm()
            if (chemical.equals(random, ignoreCase = true)) {
                displayMessage("Congratulations! You guessed it right. It was $random.")
            } else {
                displayMessage("Sorry, wrong guess. The correct answer was $random.")
            }
            binding.guessInput.text.clear()
            hideKeyboard()
        }
    }

    private fun handleAddChemical() {
        val chemical = binding.addInput.text.toString()
        if (chemical.isEmpty()) {
            displayMessage("Please input chemical to add.")
        } else if (chemicals.contains(chemical)) {
            displayMessage("Chemical '$chemical' is already available.")
        } else {
            chemicals.add(chemical)
            displayMessage("Chemical '$chemical' added successfully.")
        }
        binding.addInput.text.clear()
        hideKeyboard()
    }

    private fun displayMessage(message: String) {
        binding.message.text = message
    }

    companion object {
        fun start(activityContext: Context) {
            activityContext.startActivity(Intent(activityContext, ChemicalActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }
    }

}
package miu.mdp.assignment5.survey

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import miu.mdp.assignment5.R
import miu.mdp.assignment5.databinding.ActivitySurveyBinding
import miu.mdp.core.BaseActivity
import miu.mdp.core.showToast

class SurveyActivity : BaseActivity<ActivitySurveyBinding>() {
    private val selectedOptions = mutableMapOf<Int, Int>()
    private val repository = Repository()

    private var isFoodSurvey: Boolean = true
    private val questions: List<Question> by lazy {
        if (isFoodSurvey) repository.getFoodQuestions() else repository.getDietaryQuestions()
    }
    private val title: String by lazy {
        if (isFoodSurvey) getString(R.string.s_food_preferences) else getString(R.string.s_dietary_habit_preferences)
    }

    override fun initializeBinding(inflater: LayoutInflater) = ActivitySurveyBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        initViews()
    }

    private fun initData() {
        isFoodSurvey = intent.getBooleanExtra(EXTRA_SURVEY_TYPE, false)
    }

    private fun initViews() {
        setTitle()
        setupRecyclerView()
        setupEvents()
    }

    private fun setTitle() {
        binding.title.text = title
    }

    private fun setupEvents() {
        binding.submitBtn.setOnClickListener {
            if (areAllQuestionsAnswered()) {
                val result = getResultString()
                binding.result.text = result
            } else {
                showToast("You must answer all questions")
            }
        }
    }

    private fun setupRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SurveyAdapter(questions, selectedOptions)
    }

    private fun areAllQuestionsAnswered() = selectedOptions.size == questions.size

    private fun getResultString(): String {
        val resultStringBuilder = StringBuilder()

        for ((position, selectedOptionId) in selectedOptions) {
            val question = questions[position]
            val questionTitle = question.text
            val selectedOption = question.options.find { it.id == selectedOptionId }

            if (selectedOption != null) {
                resultStringBuilder.append("$questionTitle : ${selectedOption.text}\n")
            }
        }

        return "$resultStringBuilder"
    }


    companion object {
        private const val EXTRA_SURVEY_TYPE = "extra_survey_type"

        fun start(activityContext: Context, isFoodSurvey: Boolean = true) {
            activityContext.startActivity(Intent(activityContext, SurveyActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                putExtra(EXTRA_SURVEY_TYPE, isFoodSurvey)
            })
        }

    }
}

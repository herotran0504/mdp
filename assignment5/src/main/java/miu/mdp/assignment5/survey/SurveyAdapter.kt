package miu.mdp.assignment5.survey

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import miu.mdp.assignment5.databinding.ItemAnswerBinding
import miu.mdp.assignment5.databinding.ItemQuestionBinding
import miu.mdp.assignment5.survey.model.Question

class SurveyAdapter(
    private val questions: List<Question>,
    private val selectedOptions: MutableMap<Int, Int>
) : RecyclerView.Adapter<SurveyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemQuestionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = questions[position]
        bindQuestion(holder, question)
        setupOptions(holder)
        bindOptions(question, holder, position)
    }

    override fun getItemCount() = questions.size

    private fun bindOptions(question: Question, holder: ViewHolder, position: Int) {
        for (i in question.options.indices) {
            val radioButton = createStyledRadioButton(holder.binding.options.context)
            radioButton.text = question.options[i].text
            radioButton.id = question.options[i].id

            holder.binding.options.addView(radioButton)

            radioButton.setOnCheckedChangeListener { _, checked ->
                if (checked) {
                    selectedOptions[position] = question.options[i].id
                }
            }
        }

        selectedOptions[position]?.let { holder.binding.options.check(it) }
    }

    private fun setupOptions(holder: ViewHolder) {
        holder.binding.options.setOnCheckedChangeListener(null)
        holder.binding.options.removeAllViews()
    }

    private fun bindQuestion(holder: ViewHolder, question: Question) {
        holder.binding.question.text = question.text
    }

    private fun createStyledRadioButton(context: Context): RadioButton {
        return ItemAnswerBinding.inflate(LayoutInflater.from(context)).root
    }


    class ViewHolder(val binding: ItemQuestionBinding) : RecyclerView.ViewHolder(binding.root)
}

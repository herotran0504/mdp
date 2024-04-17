package miu.mdp.assignment5.survey.model

data class Question(val id: Int, val text: String, val options: List<Option>)

data class Option(val id: Int, val text: String)
